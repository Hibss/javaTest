package com.syz.java.test.java8.stream;

import com.google.common.collect.Lists;
import com.syz.java.test.entity.User;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author steven.sheng
 * @Date 2020/3/10/01011:32
 */
public class StreamTest {

    static Integer size = 1000;

    public static List<User> init(Integer count) {
        Integer size = StreamTest.size;
        if (count != null) {
            size = count;
        }
        List<User> users = Lists.newArrayListWithCapacity(size);
        for (Integer i = 0; i < size; i++) {
            User user = new User(i * 10, i.toString() + "name");
            users.add(user);
        }
        return users;
    }

    public static void main(String[] args) {
//        List<User> users = StreamTest.init(null);
//        testParallel(users);
        List<User> users = StreamTest.init(10);
//        users.sort((a,b) -> b.getAge().compareTo(a.getAge()));
        System.out.println(users);
        totalAge(users);
//        System.out.println(distinctStr(users));
//        System.out.println(allMatchUser(users));
//        System.out.println(noneMatchUser(users));
//        System.out.println(anyMatchUser(users));
//        optionalUser(users);
//        System.out.println(reduceAgeUser(users));


//        List<Integer> numbers = initNumber(100);
//        System.out.println(numbers);
//        System.out.println(squareNumber(numbers));

//        List<Integer[]> pairNumber = pairNumber(numbers, numbers);
//        pairNumber.stream().map(a-> a[0] + "--" + a[1]).forEach(System.out::println);

//        System.out.println(range(80));

//        initTriangle(100);
    }

    private static void totalAge(List<User> users) {
        System.out.println(users.stream().collect(Collectors.reducing(0,User::getAge,Integer::sum)));
        System.out.println(users.stream().map(User::getAge).reduce(0,Integer::sum));
        System.out.println(users.stream().mapToInt(User::getAge).sum());
    }

    private static List<Integer[]> initTriangle(Integer max) {
        IntStream.rangeClosed(0, max)
                .filter(a->a>0)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, max)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(index -> index[2] % 1 == 0 && index[2] < max)
                ).forEach(a-> System.out.println(a[0]+"--"+a[1]+"----"+a[2]));
        return null;
    }

    private static List<Integer> range(int max) {
        return IntStream.rangeClosed(0, max).filter(a -> a % 2 == 0).boxed().collect(Collectors.toList());
    }

    private static Integer reduceAgeUser(List<User> users) {
        return users.stream().map(User::getAge).reduce((a, b) -> a + b).orElse(0);
//        return users.stream().map(User::getAge).reduce(0,(a,b)->a+b);
    }

    private static void optionalUser(List<User> users) {
        User user = users.stream().filter(a -> a.getAge() == 800).findAny().orElse(new User(1, "222"));
        System.out.println(user);
        users.stream().filter(a -> a.getAge() == 80).findAny().ifPresent(System.out::println);
    }

    private static boolean anyMatchUser(List<User> users) {
        return users.stream().anyMatch(a -> a.getAge() == 90);
    }

    private static boolean noneMatchUser(List<User> users) {
        return users.stream().noneMatch(a -> a.getAge() > 100);
    }

    private static boolean allMatchUser(List<User> users) {
//        return users.stream().allMatch(a->a.getName().contains("name"));
        return users.stream().map(User::getName).allMatch(a -> a.contains("name"));
    }

    private static List<Integer[]> pairNumber(List<Integer> numbers, List<Integer> integers) {
        return numbers.stream()
                .flatMap(a -> integers.stream().filter(b -> (a + b) % 3 == 0).map(b -> new Integer[]{a, b}))
                .collect(Collectors.toList());
    }

    private static List<Integer> squareNumber(List<Integer> numbers) {
        return numbers.stream().map(a -> a * a).collect(Collectors.toList());
    }

    private static List<Integer> initNumber(Integer count) {
        count = count == null ? size : count;
        List<Integer> result = Lists.newArrayList();
        for (Integer i = 0; i < count; i++) {
            result.add(i);
        }
        return result;
    }

    private static List<String> distinctStr(List<User> users) {
        return users.stream()
                .map(User::getName)
                .map(a -> a.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private static void testParallel(List<User> users) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(users.size());
        List<User> collect = users.stream().filter(a -> a.getAge() > 500).collect(Collectors.toList());
        System.out.println(users.size());
        stopWatch.stop();
        System.out.println(stopWatch.getTime());

        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        users.parallelStream().filter(a -> a.getAge() > 500).collect(Collectors.toList());
        System.out.println(users.size());
        List<User> collect1 = users.stream().filter(a -> a.getAge() > 500).collect(Collectors.toList());
        System.out.println(users.size());
        stopWatch1.stop();
        System.out.println(stopWatch1.getTime());
    }

}
