package de.fhg.iais.roberta.ast.syntax.methods;

import java.util.List;

import de.fhg.iais.roberta.ast.syntax.BlocklyBlockProperties;
import de.fhg.iais.roberta.ast.syntax.BlocklyComment;
import de.fhg.iais.roberta.ast.syntax.BlocklyConstants;
import de.fhg.iais.roberta.ast.syntax.Phrase;
import de.fhg.iais.roberta.ast.syntax.expr.EmptyExpr;
import de.fhg.iais.roberta.ast.syntax.expr.Expr;
import de.fhg.iais.roberta.ast.syntax.expr.ExprList;
import de.fhg.iais.roberta.ast.syntax.expr.Var;
import de.fhg.iais.roberta.ast.transformer.AstJaxbTransformerHelper;
import de.fhg.iais.roberta.ast.transformer.JaxbAstTransformer;
import de.fhg.iais.roberta.ast.typecheck.BlocklyType;
import de.fhg.iais.roberta.ast.visitor.AstVisitor;
import de.fhg.iais.roberta.blockly.generated.Arg;
import de.fhg.iais.roberta.blockly.generated.Block;
import de.fhg.iais.roberta.blockly.generated.Mutation;
import de.fhg.iais.roberta.blockly.generated.Value;
import de.fhg.iais.roberta.dbc.Assert;

/**
 * This class represents the <b>robProcedures_defreturn</b> block from Blockly
 * into the AST (abstract syntax tree). Object from this class is used to create a method with return value<br/>
 */
public class MethodCall<V> extends Method<V> {
    private final String methodName;
    private final ExprList<V> parameters;
    private final ExprList<V> parametersValues;
    private final BlocklyType returnType;

    private MethodCall(
        String methodName,
        ExprList<V> parameters,
        ExprList<V> parametersValues,
        BlocklyType returnType,
        BlocklyBlockProperties properties,
        BlocklyComment comment) {
        super(Phrase.Kind.METHOD_CALL, properties, comment);
        Assert.isTrue(!methodName.equals("") && parameters.isReadOnly() && parametersValues.isReadOnly());
        this.methodName = methodName;
        this.parameters = parameters;
        this.parametersValues = parametersValues;
        this.returnType = returnType;
        setReadOnly();
    }

    /**
     * creates instance of {@link MethodCall}. This instance is read only and cannot be modified.
     *
     * @param methodName
     * @param parameters
     * @param body of the method
     * @param properties of the block (see {@link BlocklyBlockProperties}),
     * @param comment that user has added to the block,
     * @param return_ type of the method
     * @return read only object of class {@link MethodCall}
     */
    public static <V> MethodCall<V> make(
        String methodName,
        ExprList<V> parameters,
        ExprList<V> parametersValues,
        BlocklyType returnType,
        BlocklyBlockProperties properties,
        BlocklyComment comment) {
        return new MethodCall<V>(methodName, parameters, parametersValues, returnType, properties, comment);
    }

    public static <V> Phrase<V> jaxbToAst(Block block, JaxbAstTransformer<V> helper) {
        BlocklyType outputType = block.getMutation().getOutputType() == null ? null : BlocklyType.get(block.getMutation().getOutputType());
        String methodName = block.getMutation().getName();
        List<Arg> arguments = block.getMutation().getArg();
        ExprList<V> parameters = helper.argumentsToExprList(arguments);

        List<Value> values = helper.extractValues(block, (short) arguments.size());

        ExprList<V> parametersValues = helper.valuesToExprList(values, EmptyExpr.class, arguments.size(), BlocklyConstants.ARG);

        return MethodCall.make(methodName, parameters, parametersValues, outputType, helper.extractBlockProperties(block), helper.extractComment(block));
    }

    /**
     * @return the methodName
     */
    public String getMethodName() {
        return this.methodName;
    }

    /**
     * @return the parameters
     */
    public ExprList<V> getParameters() {
        return this.parameters;
    }

    /**
     * @return the parametersValues
     */
    public ExprList<V> getParametersValues() {
        return this.parametersValues;
    }

    /**
     * @return the return_
     */
    public BlocklyType getReturnType() {
        return this.returnType;
    }

    @Override
    public String toString() {
        return "MethodCall [" + this.methodName + ", " + this.parameters + ", " + this.parametersValues + ", " + this.returnType + "]";
    }

    @Override
    protected V accept(AstVisitor<V> visitor) {
        return visitor.visitMethodCall(this);
    }

    @Override
    public Block astToBlock() {
        Block jaxbDestination = new Block();
        AstJaxbTransformerHelper.setBasicProperties(this, jaxbDestination);
        Mutation mutation = new Mutation();
        mutation.setName(getMethodName());
        if ( this.returnType != null ) {
            mutation.setOutputType(this.returnType.getBlocklyName());
        }
        if ( this.parameters.get().size() != 0 ) {
            for ( Expr<V> parameter : this.parameters.get() ) {
                Arg arg = new Arg();
                arg.setName(((Var<V>) parameter).getValue());
                arg.setType(((Var<V>) parameter).getTypeVar().getBlocklyName());
                mutation.getArg().add(arg);
            }
        }
        jaxbDestination.setMutation(mutation);
        int counter = 0;
        for ( Expr<V> parameterValue : this.parametersValues.get() ) {
            AstJaxbTransformerHelper.addValue(jaxbDestination, BlocklyConstants.ARG + counter, parameterValue);
            counter++;
        }

        return jaxbDestination;
    }
}
