/*
 * This is a class GENERATED by the TransportGenerator maven plugin. DON'T MODIFY IT.
 * IF you modify it, your work may be lost: the class will be overwritten automatically
 * when the maven plugin is re-executed for any reasons.
 */
package de.fhg.iais.roberta.generated.restEntities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * the request description for the /program/delete REST request<br><br>
 * Version: 1<br>
 * Datum: 2020-06-15
 */
public class DeleteRequest extends BaseRequest {
    protected String programName;
    protected String author;

    /**
     * the request description for the /program/delete REST request
     */
    public static DeleteRequest make() {
        return new DeleteRequest();
    }

    /**
     * the request description for the /program/delete REST request
     */
    public static DeleteRequest makeFromString(String jsonS) {
        try {
            JSONObject jsonO = new JSONObject(jsonS);
            return make(jsonO);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON parse error when parsing: " + jsonS, e);
        }
    }

    /**
     * the request description for the /program/delete REST request
     */
    public static DeleteRequest makeFromProperties(String cmd, String programName, String author) {
        DeleteRequest entity = new DeleteRequest();
        entity.setCmd(cmd);
        entity.setProgramName(programName);
        entity.setAuthor(author);
        entity.immutable();
        return entity;
    }

    /**
     * the request description for the /program/delete REST request
     */
    public static DeleteRequest make(JSONObject jsonO) {
        return make().merge(jsonO).immutable();
    }

    /**
     * merge the properties of a JSON-object into this bean. The bean must be "under construction".
     * The keys of the JSON-Object must be valid. The bean remains "under construction".<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    public DeleteRequest merge(JSONObject jsonO) {
        try {
            for ( String key : JSONObject.getNames(jsonO) ) {
                if ( "_version".equals(key) ) {
                } else if ( "cmd".equals(key) ) {
                    setCmd(jsonO.optString(key));
                } else if ( "programName".equals(key) ) {
                    setProgramName(jsonO.getString(key));
                } else if ( "author".equals(key) ) {
                    setAuthor(jsonO.getString(key));
                } else {
                    throw new RuntimeException("JSON parse error. Found invalid key: " + key + " in " + jsonO);
                }
            }
            return this;
        } catch ( Exception e ) {
            throw new RuntimeException("JSON parse / casting error when parsing: " + jsonO, e);
        }
    }

    /**
     * moves a bean from state "under construction" to state "immutable".<br>
     * Checks whether all required fields are set. All lists are made immutable.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    public DeleteRequest immutable() {
        if ( this.immutable ) {
            return this;
        }
        this.immutable = true;
        return validate();
    }

    /**
     * Checks whether all required fields are set.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    private DeleteRequest validate() {
        String _message = null;
        if ( !this.immutable ) {
            _message = "DeleteRequest-object is already immutable: " + this;
        }
        if ( programName == null ) {
            _message = "required property programName of DeleteRequest-object is not set: " + this;
        }
        if ( author == null ) {
            _message = "required property author of DeleteRequest-object is not set: " + this;
        }
        if ( _message != null ) {
            this.immutable = false;
            throw new RuntimeException(_message);
        }
        return this;
    }

    /**
     * GET programName. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getProgramName() {
        if ( !this.immutable ) {
            throw new RuntimeException("no programName from an object under construction: " + this);
        }
        return this.programName;
    }

    /**
     * SET programName. Object must be mutable.
     */
    public DeleteRequest setProgramName(String programName) {
        if ( this.immutable ) {
            throw new RuntimeException("programName assigned to an immutable object: " + this);
        }
        this.programName = programName;
        return this;
    }

    /**
     * GET author. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getAuthor() {
        if ( !this.immutable ) {
            throw new RuntimeException("no author from an object under construction: " + this);
        }
        return this.author;
    }

    /**
     * SET author. Object must be mutable.
     */
    public DeleteRequest setAuthor(String author) {
        if ( this.immutable ) {
            throw new RuntimeException("author assigned to an immutable object: " + this);
        }
        this.author = author;
        return this;
    }

    /**
     * generates a JSON-object from an immutable bean.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    public JSONObject toJson() {
        if ( !this.immutable ) {
            throw new RuntimeException("no JSON from an object under construction: " + this);
        }
        JSONObject jsonO = new JSONObject();
        try {
            jsonO.put("_version", "1");
            if ( this.cmd != null ) {
                jsonO.put("cmd", this.cmd);
            }
            jsonO.put("programName", this.programName);
            jsonO.put("author", this.author);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON unparse error when unparsing: " + this, e);
        }
        return jsonO;
    }

    @Override
    public String toString() {
        return "DeleteRequest [immutable=" + this.immutable + ", cmd=" + this.cmd + ", programName=" + this.programName + ", author=" + this.author + " ]";
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("no hashCode from transport beans!");
    }

    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("no equals from transport beans!");
    }

}
