package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

public class ConstructArr {

    public int[] constructArr(int[] a){
        int[] b = new int[a.length];
        int left = 1;
        for (int i=0;i<b.length;i++){
            b[i] = left;
            left*=a[i];
        }
        int right = 1;
        for (int j = a.length - 1 ;j >= 0;j--){
            b[j] *= right;
            right *= a[j];
        }
        return b;
    }
}
