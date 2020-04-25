package com.jeeho.common.base.DataStructure.SortingAlgorithm;

import com.jeeho.common.base.DataStructure.interfaces.IArraySort;

import java.util.Arrays;

public class SelectSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        for (int i = 0; i < arr.length ; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length;j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (minIndex != i){
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }

    public static void main(String args[]) throws Exception {
        SelectSort selectSort = new SelectSort();
        int[] sort = selectSort.sort(new int[]{3,5,1,7,2});
        for (int i = 0;i<sort.length;i++){
            System.out.println(sort[i]);
        }
    }
}
