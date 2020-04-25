package com.jeeho.common.Datatruct;

/**
 * 选择排序
 * 1.首先从未排序的数组中寻找最小元素，放到数组的起始位置。   （这是可以将数组分为已经排序好的数组，和未排序数组）
 * 2.再从未排序数组中选择最小元素，放置到已排序数组元素的末尾
 * 3.重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {

    public int[] selection(int args[]){
        int minIndex = 0;
        int tempp = 0;
        for (int i = 0;i < args.length; i++){
            minIndex = i;
            for (int j = i + 1; j < args.length ; j++){
                if (args[j] < args[i])
                    minIndex = j;
            }
            tempp = args[minIndex];
            args[minIndex] = args[i];
            args[i] = tempp;
        }
        return args;
    }
}
