package com.jeeho.common.persistence;

import com.jeeho.common.web.validators.CaseMode;
import com.jeeho.common.web.validators.CheckCase;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class User4 {

    private int id;
    @NotNull
    private String userName;
    @NotNull(message = "日期不能为空！")
    private Date regTime;
    @NotNull
    @CheckCase(value = CaseMode.UPPER)
    private String passWord;

    public User4() {
    }

    public User4(int id, String userName, Date regTime, String passWord) {
        this.id = id;
        this.userName = userName;
        this.regTime = regTime;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User4{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", regTime=" + regTime +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
