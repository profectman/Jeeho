package com.jeeho.common.base.DataStructure.SortingAlgorithm;

import com.jeeho.common.base.DataStructure.interfaces.IArraySort;

import java.util.Arrays;

public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        for (int i =0;i<arr.length;i++){   //[i,len-1]为未排序数组
            int tmp = arr[i];  //记录下但钱当前未排序数组第一个元素的值
            int j = i;
            while (j>0 && tmp < arr[j - 1]){  //
                arr[j] = arr [j - 1];
                j--;
            }
            if (j != i)
                arr[j] = tmp;  //将值插入进来
        }
        return arr;
    }

    public static void main(String args[]) throws Exception {
        InsertSort insertSort = new InsertSort();
        int[] sort = insertSort.sort(new int[]{4,2,6,1,2,0});
        for (int i=0;i<sort.length;i++){
            System.out.println(sort[i]);
        }

    }
}
