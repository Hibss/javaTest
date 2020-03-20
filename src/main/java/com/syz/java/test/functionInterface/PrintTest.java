package com.syz.java.test.functionInterface;

import org.springframework.util.StringUtils;

import java.util.Base64;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ProjectName: javaTest
 * @Package: com.syz.java.test.functionInterface
 * @ClassName: PrintTest
 * @Author: Administrator
 * @Description:
 * @Date 2020/1/3/00315:28
 */
public class PrintTest {
    static Print print = System.out::println;
    static Empty empty = str -> StringUtils.isEmpty(str);


    static Consumer consumer = System.out::println;

    static Function<String,String> function = str->{
        return new String(Base64.getEncoder().encode(str.getBytes()));
    } ;
    static Supplier<PrintTest> supplier = ()->{
        return new PrintTest();
    };
    public static void main(String[] args) {
//        String aa = "hello world!!!";
//        Object i = new Object();
//        print.print(aa);
//        print.print(i);
//        consumer.accept(i);
//        consumer.accept(aa);
//        System.out.println(empty.empty(aa));
//        System.out.println(empty.empty(aa));
//        System.out.println(empty.empty("     "));
//        System.out.println(empty.empty(""));
//        System.out.println(empty.empty(null));
//        printArray(str -> print.print(str),
//                str -> System.out.println(empty.empty(str))
//                , "123",null,"   as");
//        System.out.println(predictArray(str->{
//            return empty.empty(str);
//        },str->{
//            return empty.empty(str);
//        },""));
//        functionTest("123456");
//        functionTest("MTIzNDU2");
        PrintTest printTest = supplier.get();
        printTest.printArray();
    }

    private void printArray() {
        functionTest("123456");
        functionTest("TVRJek5EVTI=");
    }


    public static void functionTest(String aa){
        System.out.println(function.apply(aa));
        System.out.println(function.andThen(function).apply(aa));
    }

    public static boolean predictArray(Predicate<String> predicate1,Predicate<String> predicate2,String... message){
        boolean result = true;
        for (String s : message) {
            result = result && predicate1.and(predicate2).test(s);
        }
        return result;
    }

    public static void printArray(Consumer<String> consumer1, Consumer<String> consumer2, String... message) {
        for (String s : message) {
            consumer1.andThen(consumer2).accept(s);
        }

    }

}
