package com.syz.java.test.algorithm;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author steven.sheng
 * @Date 2019/8/26/02610:03
 */
public class ExcelSummary {

    static List<Bean> nums;
    static BigDecimal sum;
    static List<CalculateBean> result;
    static {
        String sumStr = "6967727.26";
        sum = new BigDecimal(sumStr);
        String info = "30032.93," +
                "34338.13," +
                "44507.33," +
                "59128.11," +
                "60395.43," +
                "130055.05," +
                "147473.59," +
                "179827.83," +
                "212174.96," +
                "235835.31," +
                "298155.7," +
                "303514.78," +
                "328355.62," +
                "329188.43," +
                "566137.1," +
                "741486.16," +
                "750380.35," +
                "823401.06," +
                "913825.77," +
                "970312.12," +
                "980769.41," +
                "999997.3";
        String index = "1," +
                "2," +
                "3," +
                "4," +
                "5," +
                "6," +
                "7," +
                "8," +
                "9," +
                "10," +
                "11," +
                "12," +
                "13," +
                "14," +
                "15," +
                "16," +
                "17," +
                "18," +
                "19," +
                "20," +
                "21," +
                "22";
        String[] infos = info.split(",");
        String indexs[] = index.split(",");
        nums = Lists.newArrayList();
        for (int i = 0; i < infos.length; i++) {
            nums.add(new Bean(Integer.parseInt(indexs[i]),new BigDecimal(infos[i])));
        }
    }

    public static void main(String[] args) {
        result = Lists.newArrayList();
//        calculateOne();
//        calculateTwo();
//        calculateThree();
//        calculateFour();
//        calculateFive();
        System.out.println(summary());
        calculateSix();
        result = result.stream().sorted(Comparator.comparing(CalculateBean::getDiff)).collect(Collectors.toList());
        System.out.println(result.size());
        List<CalculateBean> soutSize = result.subList(0,100);
        for (CalculateBean calculateBean : soutSize) {
            System.out.println(calculateBean);
        }
    }

    private static Double summary() {
        return  nums.stream().mapToDouble((bean) -> {
            return bean.getNum().doubleValue();
        }).sum();
    }

    private static void calculateSix() {
        List<Bean> sixNum;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 1; j < nums.size(); j++) {
                if(j<=i){
                    continue;
                }
                for (int k = 2; k < nums.size(); k++) {
                    if(k<=j){
                        continue;
                    }
                    for (int l = 3; l < nums.size(); l++) {
                        if(l<=k){
                            continue;
                        }
                        for (int m = 4; m < nums.size(); m++) {
                            if(m<=l){
                                continue;
                            }
                            for (int n = 5; n < nums.size(); n++) {
                                if(n<=m){
                                    continue;
                                }
                                sixNum = Lists.newArrayList();
                                sixNum.add(nums.get(i));
                                sixNum.add(nums.get(j));
                                sixNum.add(nums.get(k));
                                sixNum.add(nums.get(l));
                                sixNum.add(nums.get(m));
                                sixNum.add(nums.get(n));
                                result.add(CalculateBean.builder()
                                        .diff(sum.subtract(nums.get(i).getNum()).subtract(nums.get(j).getNum()).subtract(nums.get(k).getNum())
                                                .subtract(nums.get(l).getNum())
                                                .subtract(nums.get(m).getNum())
                                                .subtract(nums.get(n).getNum()))
                                        .nums(sixNum)
                                        .sum(sum)
                                        .summary(nums.get(i).getNum().add(nums.get(j).getNum()).add(nums.get(k).getNum()).add(nums.get(l).getNum())
                                                .add(nums.get(m).getNum())
                                                .add(nums.get(n).getNum()))
                                        .build());
                            }

                        }

                    }
                }
            }
        }
    }

    private static void calculateFive() {
        List<Bean> fiveNum;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 1; j < nums.size(); j++) {
                if(j<=i){
                    continue;
                }
                for (int k = 2; k < nums.size(); k++) {
                    if(k<=j){
                        continue;
                    }
                    for (int l = 3; l < nums.size(); l++) {
                        if(l<=k){
                            continue;
                        }
                        for (int m = 4; m < nums.size(); m++) {
                            if(m<=l){
                                continue;
                            }
                            fiveNum = Lists.newArrayList();
                            fiveNum.add(nums.get(i));
                            fiveNum.add(nums.get(j));
                            fiveNum.add(nums.get(k));
                            fiveNum.add(nums.get(l));
                            fiveNum.add(nums.get(m));
                            result.add(CalculateBean.builder()
                                    .diff(sum.subtract(nums.get(i).getNum()).subtract(nums.get(j).getNum()).subtract(nums.get(k).getNum())
                                            .subtract(nums.get(l).getNum())
                                    .subtract(nums.get(m).getNum()))
                                    .nums(fiveNum)
                                    .sum(sum)
                                    .summary(nums.get(i).getNum().add(nums.get(j).getNum()).add(nums.get(k).getNum()).add(nums.get(l).getNum()).add(nums.get(m).getNum()))
                                    .build());
                        }

                    }
                }
            }
        }
    }

    private static void calculateFour() {
        List<Bean> fourNum;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 1; j < nums.size(); j++) {
                if(j<=i){
                    continue;
                }
                for (int k = 2; k < nums.size(); k++) {
                    if(k<=j){
                        continue;
                    }
                    for (int l = 3; l < nums.size(); l++) {
                        if(l<=k){
                            continue;
                        }
                        fourNum = Lists.newArrayList();
                        fourNum.add(nums.get(i));
                        fourNum.add(nums.get(j));
                        fourNum.add(nums.get(k));
                        fourNum.add(nums.get(l));
                        result.add(CalculateBean.builder()
                                .diff(sum.subtract(nums.get(i).getNum()).subtract(nums.get(j).getNum()).subtract(nums.get(k).getNum()).subtract(nums.get(l).getNum()))
                                .nums(fourNum)
                                .sum(sum)
                                .summary(nums.get(i).getNum().add(nums.get(j).getNum()).add(nums.get(k).getNum()).add(nums.get(l).getNum()))
                                .build());
                    }
                }
            }
        }
    }

    private static void calculateThree() {
        List<Bean> threeNum;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 1; j < nums.size(); j++) {
                if(j<=i){
                    continue;
                }
                for (int k = 2; k < nums.size(); k++) {
                    if(k<=j){
                        continue;
                    }
                    threeNum = Lists.newArrayList();
                    threeNum.add(nums.get(i));
                    threeNum.add(nums.get(j));
                    threeNum.add(nums.get(k));
                    result.add(CalculateBean.builder()
                            .diff(sum.subtract(nums.get(i).getNum()).subtract(nums.get(j).getNum()).subtract(nums.get(k).getNum()))
                            .nums(threeNum)
                            .sum(sum)
                            .summary(nums.get(i).getNum().add(nums.get(j).getNum()).add(nums.get(k).getNum()))
                            .build());
                }
            }
        }
    }

    private static void calculateTwo() {
        List<Bean> twoNum;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 1; j < nums.size() -1; j++) {
                if(j<=i){
                    continue;
                }
                twoNum = Lists.newArrayList();
                twoNum.add(nums.get(i));
                twoNum.add(nums.get(j));
                result.add(CalculateBean.builder()
                        .diff(sum.subtract(nums.get(i).getNum()).subtract(nums.get(j).getNum()))
                        .nums(twoNum)
                        .sum(sum)
                        .summary(nums.get(i).getNum().add(nums.get(j).getNum()))
                        .build());
            }
        }
    }

    private static void calculateOne() {
        List<Bean> oneNum;
        for (Bean num : nums) {
            oneNum = Lists.newArrayListWithCapacity(1);
            oneNum.add(num);
            result.add(CalculateBean.builder()
                    .diff(sum.subtract(num.getNum()))
                    .nums(oneNum)
                    .sum(sum)
                    .summary(num.getNum())
                    .build());
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class CalculateBean{
        BigDecimal diff;
        BigDecimal summary;
        BigDecimal sum;
        List<Bean> nums;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Bean{
        Integer index;
        BigDecimal num;
    }

}
