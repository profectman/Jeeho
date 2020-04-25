package com.jeeho.common.base.DataStructure.SortingAlgorithm;

import com.jeeho.common.base.DataStructure.interfaces.IArraySort;

import java.util.Arrays;

public class MergeSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        int len = arr.length;

        mergeSort(arr,0,len - 1);

        return arr;
    }

    private void mergeSort(int[] arr,int l,int r){
        if (l == r)
            return ;
        else{
            int m = (l+r)/2;

            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);

            merge(arr,l,m,r);
        }
    }

    private void merge(int[] arr, int l, int middle, int r) {
        int[] leftArr = new int[middle - l + 1];
        int[] rightArr = new int[r - middle + 1];

        for (int i = l; i <= middle; i++) {
            leftArr[i - l] = arr[i];
        }
        for (int i = middle + 1 ; i <= r; i++) {
            rightArr[i - middle - 1 ] = arr[i];
        }

        int i = 0,j = 0;
        int k = l;

        while (i <= middle || (j > middle && j <= r ) ){
            if ( i > middle)
                arr[k++] = rightArr[j++];
            else if ( j > r)
                arr[k++] = leftArr[i++];
            else if (leftArr[i] > rightArr[j])
                arr[k++] = rightArr[j++];
            else
                arr[k++] = leftArr[i++];
        }
    }
    
    public static void main(String args[]) throws Exception {
        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.sort(new int[]{33,21,73,57});

        for (int i =0;i<sort.length;i++)
            System.out.println(sort[i] + " ");
    }
}
