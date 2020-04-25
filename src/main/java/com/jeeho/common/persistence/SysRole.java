package com.jeeho.common.persistence;

import java.util.Date;

public class SysRole {

    private String id;
    private String officeId;
    private String name;
    private String enName;
    private String roleType;
    private String dataScope;
    private String isSys;
    private String useAble;
    private String createBy;
    private Date   createDate;
    private String updateBy;
    private Date   updateDate;
    private String remarks;
    private String delFlag;

    public SysRole() {
    }

    public SysRole(String id, String officeId, String name, String enName, String roleType, String dataScope, String isSys, String useAble, String createBy, Date createDate, String updateBy, Date updateDate, String remarks, String delFlag) {
        this.id = id;
        this.officeId = officeId;
        this.name = name;
        this.enName = enName;
        this.roleType = roleType;
        this.dataScope = dataScope;
        this.isSys = isSys;
        this.useAble = useAble;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.remarks = remarks;
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    public String getUseAble() {
        return useAble;
    }

    public void setUseAble(String useAble) {
        this.useAble = useAble;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", officeId='" + officeId + '\'' +
                ", name='" + name + '\'' +
                ", enName='" + enName + '\'' +
                ", roleType='" + roleType + '\'' +
                ", dataScope='" + dataScope + '\'' +
                ", isSys='" + isSys + '\'' +
                ", useAble='" + useAble + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", remarks='" + remarks + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
