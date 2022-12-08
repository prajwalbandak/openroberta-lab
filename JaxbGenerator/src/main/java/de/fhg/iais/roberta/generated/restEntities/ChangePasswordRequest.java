/*
 * This is a class GENERATED by the TransportGenerator maven plugin. DON'T MODIFY IT.
 * IF you modify it, your work may be lost: the class will be overwritten automatically
 * when the maven plugin is re-executed for any reasons.
 */
package de.fhg.iais.roberta.generated.restEntities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * the request description for the /changePassword REST request<br><br>
 * Version: 1<br>
 * Datum: 2020-06-15
 */
public class ChangePasswordRequest extends BaseRequest {
    protected String accountName;
    protected String oldPassword;
    protected String newPassword;

    /**
     * the request description for the /changePassword REST request
     */
    public static ChangePasswordRequest make() {
        return new ChangePasswordRequest();
    }

    /**
     * the request description for the /changePassword REST request
     */
    public static ChangePasswordRequest makeFromString(String jsonS) {
        try {
            JSONObject jsonO = new JSONObject(jsonS);
            return make(jsonO);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON parse error when parsing: " + jsonS, e);
        }
    }

    /**
     * the request description for the /changePassword REST request
     */
    public static ChangePasswordRequest makeFromProperties(String cmd, String accountName, String oldPassword, String newPassword) {
        ChangePasswordRequest entity = new ChangePasswordRequest();
        entity.setCmd(cmd);
        entity.setAccountName(accountName);
        entity.setOldPassword(oldPassword);
        entity.setNewPassword(newPassword);
        entity.immutable();
        return entity;
    }

    /**
     * the request description for the /changePassword REST request
     */
    public static ChangePasswordRequest make(JSONObject jsonO) {
        return make().merge(jsonO).immutable();
    }

    /**
     * merge the properties of a JSON-object into this bean. The bean must be "under construction".
     * The keys of the JSON-Object must be valid. The bean remains "under construction".<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    public ChangePasswordRequest merge(JSONObject jsonO) {
        try {
            for ( String key : JSONObject.getNames(jsonO) ) {
                if ( "_version".equals(key) ) {
                } else if ( "cmd".equals(key) ) {
                    setCmd(jsonO.optString(key));
                } else if ( "accountName".equals(key) ) {
                    setAccountName(jsonO.getString(key));
                } else if ( "oldPassword".equals(key) ) {
                    setOldPassword(jsonO.getString(key));
                } else if ( "newPassword".equals(key) ) {
                    setNewPassword(jsonO.optString(key));
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
    public ChangePasswordRequest immutable() {
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
    private ChangePasswordRequest validate() {
        String _message = null;
        if ( !this.immutable ) {
            _message = "ChangePasswordRequest-object is already immutable: " + this;
        }
        if ( accountName == null ) {
            _message = "required property accountName of ChangePasswordRequest-object is not set: " + this;
        }
        if ( oldPassword == null ) {
            _message = "required property oldPassword of ChangePasswordRequest-object is not set: " + this;
        }
        if ( _message != null ) {
            this.immutable = false;
            throw new RuntimeException(_message);
        }
        return this;
    }

    /**
     * GET accountName. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getAccountName() {
        if ( !this.immutable ) {
            throw new RuntimeException("no accountName from an object under construction: " + this);
        }
        return this.accountName;
    }

    /**
     * SET accountName. Object must be mutable.
     */
    public ChangePasswordRequest setAccountName(String accountName) {
        if ( this.immutable ) {
            throw new RuntimeException("accountName assigned to an immutable object: " + this);
        }
        this.accountName = accountName;
        return this;
    }

    /**
     * GET oldPassword. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getOldPassword() {
        if ( !this.immutable ) {
            throw new RuntimeException("no oldPassword from an object under construction: " + this);
        }
        return this.oldPassword;
    }

    /**
     * SET oldPassword. Object must be mutable.
     */
    public ChangePasswordRequest setOldPassword(String oldPassword) {
        if ( this.immutable ) {
            throw new RuntimeException("oldPassword assigned to an immutable object: " + this);
        }
        this.oldPassword = oldPassword;
        return this;
    }

    /**
     * GET newPassword. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getNewPassword() {
        if ( !this.immutable ) {
            throw new RuntimeException("no newPassword from an object under construction: " + this);
        }
        return this.newPassword;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean newPasswordDefined() {
        return this.newPassword != null;
    }

    /**
     * SET newPassword. Object must be mutable.
     */
    public ChangePasswordRequest setNewPassword(String newPassword) {
        if ( this.immutable ) {
            throw new RuntimeException("newPassword assigned to an immutable object: " + this);
        }
        this.newPassword = newPassword;
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
            jsonO.put("accountName", this.accountName);
            jsonO.put("oldPassword", this.oldPassword);
            if ( this.newPassword != null ) {
                jsonO.put("newPassword", this.newPassword);
            }
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON unparse error when unparsing: " + this, e);
        }
        return jsonO;
    }

    @Override
    public String toString() {
        return "ChangePasswordRequest [immutable=" + this.immutable + ", cmd=" + this.cmd + ", accountName=" + this.accountName + ", oldPassword=" + this.oldPassword + ", newPassword=" + this.newPassword + " ]";
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
