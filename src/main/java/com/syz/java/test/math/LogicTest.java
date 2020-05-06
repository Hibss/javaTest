package com.syz.java.test.math;

import com.google.common.collect.Lists;
import com.syz.java.test.biz.entity.User;

import java.util.List;

/**
 * @Author steven.sheng
 * @Date 2020/3/23/02310:15
 */
public class LogicTest {

    public static void main(String[] args) {
        sortExport();
    }
    private static void sortExport() {
        Integer size = 50;
        List<Integer> nums = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            nums.add(i+1);
        }
        System.out.println(nums);
        while (nums.size() > 1){
            nums = removeNotEven(nums);
        }
        System.out.println(nums);
    }

    private static List<Integer> removeNotEven(List<Integer> nums) {
        List<Integer> temp = Lists.newArrayList();
        for (int i = 0; i < nums.size(); i++) {
            if(i % 2 != 0){
                temp.add(nums.get(i));
            }
        }
        System.out.println(temp);
        return  temp;
    }
}
