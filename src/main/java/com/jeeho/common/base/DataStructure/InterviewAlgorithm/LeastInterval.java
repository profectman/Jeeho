package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

import java.util.Arrays;

/**
 * 求任务的最短调度时间
 */
public class LeastInterval {

    public static void main(String args[]){
        char[] tasks = {'A','A','A','C','C','C'};
        LeastInterval l = new LeastInterval();
        System.out.format("输出最短时间为 ：%s %n",l.leastInterval(tasks,2));
        return;
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A'] ++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0){
            int i = 0;
            while(i <= n){
                if (map[25] == 0)
                    break;
                if (map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}
