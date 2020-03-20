package com.syz.java.test.math;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 质数计算
 * @Author steven.sheng
 * @Date 2020/3/11/01111:15
 */
public class PrimeNumberTest {
    static Integer size = 100;

    public static void main(String[] args) {
        List<Integer> nums = getPrimeList(size);
//        System.out.println(nums);
//        Collections.shuffle(nums);
//        System.out.println(nums);
//        bubbleSort(nums);
//        System.out.println(nums);
        partitionPrimes(100);
    }

    private static void partitionPrimes(int max) {
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(0, max).boxed()
                .collect(Collectors.partitioningBy(num -> isPrime(num)));
        collect.entrySet().stream().forEach(System.out::println);
    }

    private static boolean isPrime(Integer num) {
        int root = (int) Math.sqrt(num);
        return IntStream.rangeClosed(2,root).noneMatch(no->num % no == 0);
    }

    private static List<Integer> getPrimeList(int size) {
        List<Integer> result = Lists.newArrayList();
        for (int i = 2; i < size; i++) {
            if(checkPrime(i)){
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> bubbleSort(List<Integer> numbers){
        Integer before,after,size = numbers.size();
        for(int i = 0; i < size; i++){
            // 内层循环控制每轮比较次数
            for(int j = 0; j < size - i - 1; j++){
                // 按照从小到大排列
                before = numbers.get(j);
                after = numbers.get(j+1);
                if(before > after){
                    numbers.set(j,after);
                    numbers.set(j+1,before);
                }
            }
        }
        return numbers;
    }

    private static boolean checkPrime() {
        return checkPrime(10);
    }

    private static boolean checkPrime(int number) {
        Boolean flag = true;
        if(number % 2 == 0 && number != 2){
            return false;
        }
        Integer calculate = (int)Math.sqrt(number);
        for (Integer i = 2; i < calculate; i++) {
            if(number % i == 0){
                flag = false;
            }
        }
        return flag;
    }
}
