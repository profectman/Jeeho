package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一组非负的整形数组，要求它们结合在一起构成的数是最大的数
 */
public class LargestNumber {

    public class LargeNumber implements Comparator<String> {
        /**
         * @throws NullPointerException if an argument is null and this
         *                              comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from
         *                              being compared by this comparator.
         */
        @Override
        public int compare(String o1, String o2) {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums){
        String[] numbers = new String[nums.length];
        for (int i = 0;i < nums.length;i++)
            numbers[i] = String.valueOf(nums[i]);

        Arrays.sort(numbers,new LargeNumber());

        if (numbers[0].equals("0"))
            return "0";

        String result = "";

        for (String str : numbers)
            result += str;

        return result;
    }
}
