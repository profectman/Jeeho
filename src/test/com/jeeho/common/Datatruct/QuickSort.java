package com.jeeho.common.Datatruct;

/**
 * 快速排序
 * 1.从数组中挑选一个元素作为‘基准’
 * 2.基准元素选取，通常以第一个元素作为基准，从该元素的下一个元素到序列尾端中开始，依次扫描选取元素小于基准的元素方到基准元素的尾端
 *
 */
public class QuickSort {

    public int[] quickSort(int[] arr,int l,int r){

        while (l < r){
            int partition = partition(arr,l,r);
            quickSort(arr,l,partition-1);
            quickSort(arr,partition + 1,r);
        }
        return arr;
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = l;
        int index = pivot + 1;
        for (int i = index ;i < r;i++){
            if (arr[i] < arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,index-1,pivot );
        return 0;
    }

    private void swap(int[] arr, int i, int index) {
        int tem = arr[i];
        arr[i] = arr[index];
        arr[index] = tem;
    }
}
