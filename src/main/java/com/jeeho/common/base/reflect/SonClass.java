package com.jeeho.common.base.reflect;

public class SonClass extends FatherClass {

    private String mSonName;
    protected  int mSonAge;
    public String mSonBirthday;

    public void printSonMsg() {
        System.out.println("Son Msg - name : "
                + mSonName + "; age : " + mSonAge);
    }

    public String getmSonName() {
        return mSonName;
    }

    public void setmSonName(String mSonName) {
        this.mSonName = mSonName;
    }

    public int getmSonAge() {
        return mSonAge;
    }

    public void setmSonAge(int mSonAge) {
        this.mSonAge = mSonAge;
    }
}
