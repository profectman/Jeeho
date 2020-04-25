package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

/**
 * 贪心算法，获取股票最大利润
 *
 */
public class MaxProfit {

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        for (int i = 0; i < prices.length ; i++){
            if (i == prices.length - 2){
                maxProfit = Math.max(maxProfit,prices[prices.length - 2] - prices[i]);
            }else {
                for (int j = i + 1;j < prices.length; j++){
                    maxProfit = Math.max(maxProfit,prices[j] - prices[i]);
                }
            }
        }
        return 0 < maxProfit? maxProfit : 0;
    }

    public static void main(String args[]){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
