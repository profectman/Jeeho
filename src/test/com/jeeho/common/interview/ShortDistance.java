package com.jeeho.common.interview;

/**
 * 第二题：简而言之就是TSP问题。蜂巢在坐标（0,0）的位置，
 * 有五处花丛，蜜蜂从蜂巢出发，要把五处花丛的花蜜采完再回到蜂巢，
 * 最短距离是多少。输入说明：一行输入，10个数分别是五处花丛的坐标（
 * x1,y1,x2,y2,x3,y3,x4,y4,x5,y5），
 * 用空格隔开。输出说明：输出最短距离，距离向下取整。
 *
 * @笔记：
 * Math.abs(-3.14) = 3.14  //求绝对值
 * Math.floor(3.5) = 3  //向下取整
 * Math.rint(3.5) = 4  //四舍五入
 * Math.ceil(3.1) =  //向上取整
 * A%B  //求余数
 *
 * https://blog.csdn.net/weixin_38278878/article/details/79506421
 * https://blog.csdn.net/qq_21808961/article/details/77990940
 */
public class ShortDistance {

    public static void main(String[] args)
    {

        char buf[]={'a','b','c','d'};
        perm(buf, 0, buf.length-1);

    }

    public static void perm(char[] buf, int start, int end) {
        //当读到数组最后一个元素时，遍历数组
        if(start == end) {
            for (char c : buf) {
                System.out.print(c);
            }
            System.out.println("");
        } else {
            for(int i = start; i <= end; i++) {
                swap(buf, start, i);
                System.out.println(start);
                perm(buf, start + 1, end);
                //由于上面进行了交换，这里需要还原数组，因此再进行一次交换
                swap(buf, start, i);
            }
        }
    }

    //交换函数
    public static void swap(char[] buf, int i, int j) {
        char temp = buf[i];
        buf[i] = buf[j];
        buf[j] = temp;
    }
}
