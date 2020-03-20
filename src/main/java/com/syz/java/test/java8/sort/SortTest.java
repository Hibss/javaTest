package com.syz.java.test.java8.sort;

import com.google.common.collect.Lists;
import com.syz.java.test.entity.User;
import com.syz.java.test.entity.User1;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @Author steven.sheng
 * @Date 2020/3/9/00915:06
 */
public class SortTest {
    static Integer size = 10;


    public static List<User> init(){
        List<User> users = Lists.newArrayListWithCapacity(size);
        for (Integer i = 0; i < size; i++) {
            User user = new User(i*10,i.toString() + "name");
            users.add(user);
        }
        return users;
    }

    public static List<User1> initUser1(){
        List<Integer> numbers = Lists.newArrayListWithCapacity(size);
        for (Integer i = 0; i < size; i++) {
            numbers.add(i);
        }
        List<User1> users = convert(numbers,User1::new);
        System.out.println(users);
        return users;
    }

    public static List<User1> convert(List<Integer> numbers, Function<Integer,User1> function){
        List<User1> result = Lists.newArrayListWithExpectedSize(numbers.size());
        for (Integer number : numbers) {
            result.add(function.apply(number));
        }
        return result;
    }

    public static void main(String[] args) {
        List<User> users = SortTest.init();
        System.out.println(users);
//        users.sort(Comparator.comparing(User::getAge).reversed());
//        System.out.println(users);
//        joinUserName(users);
        groupUser(users);
//        oldSort(users);
//        java8Sort(users);
//        java8Sort1(users);
//        List<User1> user1s = initUser1();
//        System.out.println(user1s);
    }

    private static void groupUser(List<User> users) {
        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(user -> user.getAge() < 50 ? "young" : "old"));
        collect.entrySet().stream().forEach(System.out::println);
        Integer addition = 20, line = 50;
        Map<String, Map<String, List<User>>> collect1 = users.stream().collect(Collectors.groupingBy(user -> {
            if (user.getAge() < line) {
                return "young";
            }
            return "old";
        }, Collectors.groupingBy(user -> {
                    if (user.getAge() < line - addition) {
                        return "period 1";
                    } else if (user.getAge() < line) {
                        return "period 2";
                    } else if (user.getAge() < line + addition) {
                        return "period 3";
                    } else {
                        return "period 4";
                    }

                }

        )));
        collect1.entrySet().stream().forEach(System.out::println);
        Map<String, Long> collect2 = users.stream().collect(Collectors.groupingBy(user -> {
            if (user.getAge() < line) {
                return "young";
            }
            return "old";
        }, Collectors.counting()));
        collect2.entrySet().stream().forEach(System.out::println);
    }

    private static void joinUserName(List<User> users) {
        System.out.println(users.stream().map(User::getName).collect(Collectors.joining(",","user:",";")));
        System.out.println(users.stream().map(User::getName).collect(Collectors.reducing((a,b)->a+"--"+b)).get());
        System.out.println(users.stream().collect(Collectors.reducing("",User::getName,(a,b)->a+"--"+b)));
    }

    private static void java8Sort1(List<User> users) {
        users.sort(User::compareTo);
        System.out.println(users);
    }

    private static void java8Sort(List<User> users) {
        users.sort(Comparator.comparing(User::getAge).reversed());
        System.out.println(users);
    }

    private static void oldSort(List<User> users) {
        Collections.sort(users, (a, b) -> b.getAge().compareTo(a.getAge()));
        System.out.println(users);
    }
}
