package com.jeeho.common.Datatruct;

/**
 * 插入排序
 * 1.将待排序序列的第一个元素看作是有序序列，将第二个元素到序列尾端到当作为排序序列
 * 2.从头到尾扫描未排序序列，将每一个扫描到的未排序序列插入到数组的尾部。
 */
public class InsertSort {


    public int[] insertSort(int args[]){
        for (int i = 1;i < args.length; i++){
            int temp = args[i]; //记录下要插入元素
            int j = i;
            while ( j > 0 && temp < args[j-1]){
                args[j] = args[j - 1];
                j--;
            }
            if (j != i)
                args[j] = temp;
        }
        return args;
    }
}
