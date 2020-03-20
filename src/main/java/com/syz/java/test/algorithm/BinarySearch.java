package com.syz.java.test.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author steven.sheng
 * @Date 2019/7/31/03116:59
 */
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0 ,size = 100;i < size  ; i ++) {
            list.add(i);
        }
        System.out.println(Math.log(8.0));
        binarySearch(list,49,1);
        binarySearch(list,11111,1);
    }

    private static Integer binarySearch(List<Integer> list, int res, int count) {
        System.out.println(count + "次查找" + res);
        count++;
        Integer min = 0, max = list.size()-1,mid,guess;
        while(min < max){
            mid = (min + max) / 2;
            guess = list.get(mid);
            if(guess == res){
                return count;
            }else if(guess > res){
                return binarySearch(list.subList(0,mid - 1),res, count);
            }else{
                return binarySearch(list.subList(mid+1,list.size()),res, count);
            }
        }
        return 0;
    }
}
