package com.jeeho.common.interview;

import java.util.Scanner;

public class main01 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(test(a,b));
        }
    }

    public static int test(int n,int m){
        int result = 2;
        if(n>=m){
            return 1;
        }else{
            if(2*n >= m){
                return 2;
            }else{
                while(result*n < m){
                    result++;
                }
            }
        }
        return result;
    }
}
