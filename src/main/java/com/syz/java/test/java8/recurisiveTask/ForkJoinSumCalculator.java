package com.syz.java.test.java8.recurisiveTask;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @Author steven.sheng
 * @Date 2020/3/12/01211:19
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private Long[] numbers;
    private Integer start;
    private Integer end;

    private Long THRESHOLD = 10000L;

    public ForkJoinSumCalculator(Long[] numbers){
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(Long[] numbers,Integer start,Integer end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        Integer length = end - start;
        if(length < THRESHOLD){
            return computeSequentially();
        }
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start + length / 2,end),
                leftTask = new ForkJoinSumCalculator(numbers,start,start+length/2);
        rightTask.fork();
        return leftTask.compute() + rightTask.join();
    }

    private Long computeSequentially() {
        return Arrays.stream(numbers).reduce(0L,Long::sum);
    }

    public static void main(String[] args) {

    }
}
