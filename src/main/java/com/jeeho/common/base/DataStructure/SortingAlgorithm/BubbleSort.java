package com.jeeho.common.base.DataStructure.SortingAlgorithm;

import com.jeeho.common.base.DataStructure.interfaces.IArraySort;

import java.util.Arrays;

public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        for (int i = 0; i < arr.length; i++){
            for (int j = 0;j < arr.length - i - 1 ; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String args[]) throws Exception {
        BubbleSort sort = new BubbleSort();
        int[] sort1 = sort.sort(new int[]{2, 4, 1, 5, 2, 5, 1});
        for (int i = 0 ; i < sort1.length ; i++){
            System.out.println( sort1[i]);
        }
    }
}
