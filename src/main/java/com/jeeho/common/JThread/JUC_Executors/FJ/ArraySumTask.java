package com.jeeho.common.JThread.JUC_Executors.FJ;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * fork/join 将任务进行拆分，分成多个逻辑相同的子任务执行，并将各个执行任务进行合并
 * 核心组件：ForkJoinPool、ForkJoinTask、ForkJoinWorkerThread、WorkerQueue
 *      ForkJoinPool:构建方式： 1.默认三种构造方法 2.静态方法CommonPool
 *      任务执行方式：invoker、executor、submit分别对应任务同步执行、异步执行无返回值、异步执行有返回值。
 *
 *      ForkJoinTask：可以是现任务的fork、join 继承至Future，
 *      其有子类实现：RecursiveAction、RecursiveTask分别表示无返回值任务和有返回值任务。
 *
 *      ForkJoinWorkThread：每个工作线程内部都会有一个自己的任务队列，工作线程会优先执行当前任务队列中的任务
 *      当任务队列为空闲时，则窃取其他其他线程任务队列中的任务。
 *
 *      WorkQueue 同时支持FOFI、LOLI
 *
 *      ForkJoin框架的核心在于线程中任务的窃取
 */
public class ArraySumTask extends RecursiveTask<Long> {

    private final int begin;
    private final int end;
    private final int[] array;
    private final static int THRESHOLD = 100;

    public ArraySumTask(int begin, int end, int[] array) {
        this.begin = begin;
        this.end = end;
        this.array = array;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        long sum = 0;
        if (end - begin + 1 > THRESHOLD){
            for (int i = begin;i <= end; i++)
                sum += array[i];
        }else{
            int middle = (end - begin)/2;
            
            ArraySumTask as1 = new ArraySumTask(begin, middle, this.array);
            ArraySumTask as2 = new ArraySumTask(middle + 1, end, this.array);
            
            as1.fork();
            as2.fork();

            Long sum1 = as1.join();
            Long sum2 = as2.join();

            sum = sum1 + sum2;
        }
        return sum;
    }

    public static void main(String[] args) {
        //实例化获取fj线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //提交任务到线程池中，并获取返回结果凭证
        ForkJoinTask<Long> future = forkJoinPool.submit(new ArraySumTask(0, 9999, new int[10000]));

        //判断是否已经抛出异常或取消
        if (future.isCompletedAbnormally())
            System.out.println(future.getException());

        //获取返回结果
        try {
            Long sum = future.get();
            System.out.println("result : " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
