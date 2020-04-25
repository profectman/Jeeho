package com.jeeho.common.interview;

import java.util.Scanner;

public class main02 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        test(n,arr);
    }

    private static void test(int size,int[][] arr) {
        for(int i=0;i<size;i++){
            int result =0;
            int a = arr[i][0];
            int b = arr[i][1];
            if(a > b){
                return;
            }
            float r = (float)((a*Math.pow(-1,a)) + (b*Math.pow(-1,b)));
            if(r > 0){
                result = (int)Math.ceil(r/2);
            }else{
                result = (int)Math.floor(r/2);
            }
            System.out.println(result);
        }
    }


}
