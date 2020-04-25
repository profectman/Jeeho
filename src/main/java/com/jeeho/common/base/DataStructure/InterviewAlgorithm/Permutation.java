package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {


    public void premutation(char[] chars, int start){
        if (start == chars.length - 1) {
            System.out.println(Arrays.toString(chars));
        }
        for (int i = start; i < chars.length ; i++){
            if ( i == start || chars[start] !=chars[i] ){
                swap(chars,start,i);
                premutation(chars,start+1);
                swap(chars,start,i);
            }
        }
    }

    public void swap(char[] chars,int start,int i){
        char c  = chars[start];
        chars[start] = chars[i];
        chars[i] = c;
    }

    public static void main(String args[]){

        char[] chars = {'1','1','3'};
        Permutation permutation = new Permutation();
        permutation.premutation(chars,0);
    }
}
