package com.jeeho.common.base.Javaxx;

import java.util.Arrays;
import java.util.List;

/**
 * 1.Stream 数据源元素的队列并支持聚合操作
 * 一、Stream的创建：Stream.of()  [创建一个流数组] | Stream.generator() [创建一个不限长度的流数组]
 *                Stream.iterate() [创建一个规律数据]
 * 二、转换Stream: filter [过滤操作]
 *              | distinct [去重操作]
 *              | map [映射操作]
 *                  | mapToInt,mapToLong,mapToDouble
 *                  | flatMapToInt,flatMapToLong,flatMapToDouble
 *              | sorted [排序操作]
 *              | limit ,skip,peek[为每个新元素都添加一个执行时的消费函数]
 *              | contact [合并操作]
 * 三、汇聚Stream:  collect(Collectors.toList())
 *                 reduce()
 *
 */
public class LambdaAndStream {

    public static void main(String args[]){
        List strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");

        System.out.println("使用 Java 8: ");
        System.out.println("列表：" + strings);

        long count = strings.stream().filter( s -> s == "").count();
        System.out.println("空字符串数量为：" + count);
    }
}
