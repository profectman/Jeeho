package com.jeeho.common.pojo;

import java.io.Serializable;

public class Role implements Serializable {

    private String id;
    private String roleName;
    private String note;

    public Role() {
    }

    public Role(String id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
