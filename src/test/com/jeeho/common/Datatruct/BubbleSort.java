package com.jeeho.common.Datatruct;

/**
 * 冒泡排序
 * 1.比较相邻的元素。如果第一个比第二个元素大，就交换它们的位置。
 * 2.对每一对相邻的元素做同样的工作，从开始的第一对到结尾的最后一对。这一步做完以后最后的元素会是最大的元素。
 * 3.针对每一个元素重复以上的动作，除了最后一个元素。
 * 4.持续每次对越来越少的重复元素进行以上的比较动作，直到没有任何一个重复的元素需要比较。
 */
public class BubbleSort {
    /**
     * @param args
     * @return
     */
    public int[] BubbleSort(int[] args){
        for(int i=0;i<args.length;i++){
            for (int j=0;j<args.length - 1 - i;j++){
                if (args[j] > args[j + 1]){
                    int temp = args[j + 1];
                    args[j + 1] = args[j];
                    args[j] = temp;
                }
            }
        }
        return args;
    }
}
