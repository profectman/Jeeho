package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

import java.util.Arrays;

/**
 * 小偷偷窃问题
 * 如果偷了当前这家，就不能这一下的下一家
 * <<动态规划>>
 */
public class Rob {

    public int rob(int[] nums) {
        int[] numbers = Arrays.copyOf(nums,nums.length);
        int cur = 0;
        int pre = 0;
        for (int num : numbers){
            int temp = cur;
            cur = Math.max(num + pre,cur);
            pre = temp;
        }
        return cur;
    }

    public int rob2(int[] nums,int start){
        if (start == 0) return nums[0];
        if (start == 1) return Math.max(nums[0],nums[1]);
        if (start < 3) return Math.max(nums[2] + nums[0],nums[1]);

        return Math.max(nums[start] + rob2(nums,start -2 ),rob2(nums,start -1));
    }

    public static void main(String args[]){
        Rob rob = new Rob();
        System.out.println(rob.rob2(new int[]{2,7,9,3,1},4));
    }
}
