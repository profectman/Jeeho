package com.jeeho.common.base.DataStructure.SortingAlgorithm;

import com.jeeho.common.base.DataStructure.interfaces.IArraySort;

import java.util.Arrays;

/**
 * 堆排序（从小到大）：根据输入的数组创建一个大顶堆
 */
public class HeapSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        int len = arr.length;

        buildMaxHeap(arr,len);

        for (int i = arr.length - 1 ;i>=0;i--){
            swap(arr,0,i);
            len--;
            heapify(arr,0,len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr,int len){
        for (int i = (int) Math.floor(len/2) - 1;i>=0;i--){
            heapify(arr,i,len);
        }
    }

    private void heapify(int[] arr,int i,int len){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest])
            largest = left;

        if (right < len && arr[right] > arr[largest])
            largest = right;

        if (i != largest){
            swap(arr,i,largest);
            i = largest;
            heapify(arr,i,len);
        }
    }

    private void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String args[]) throws Exception {
        HeapSort heapSort = new HeapSort();
        int[] sort = heapSort.sort(new int[]{21, 33, 43});
    }
}
