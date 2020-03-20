package com.syz.java.test.java8.lambda;

import com.google.common.collect.Lists;
import com.syz.java.test.entity.User;
import com.syz.java.test.entity.User1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;
import java.util.stream.Stream;

/**
 * @Author steven.sheng
 * @Date 2020/3/10/01014:55
 */
public class LambdaTest {
    static Integer size = 10;

    Comparator<User> comparator = (a,b)->a.getAge().compareTo(b.getAge());
    ToIntBiFunction<User,User> toIntBiFunction = (a,b) -> a.getAge().compareTo(b.getAge());
    BiFunction<User,User,Integer> biFunction = (a,b) ->a.getAge()+b.getAge();

    public static List<User> init(){
        List<User> users = Lists.newArrayListWithCapacity(size);
        for (Integer i = 0; i < size; i++) {
            User user = new User(i,i.toString() + "name");
            users.add(user);
        }
        return users;
    }

    public static void main(String[] args) throws IOException {
//        testFileReader();
//        testConsumer();
//        testFunction();
        testFile("D:/test.txt");
    }

    private static void testFile(String fileName) throws IOException{

        try(Stream<String> lines = Files.lines(Paths.get(fileName), Charset.defaultCharset())){
//            lines.flatMap(line -> Arrays.stream(line.split("")))
//                    .forEach(System.out::println);
            lines.forEach(System.out::println);
        }finally {

        }
    }

    private static void testFunction() {
        List<User> users = init();
        List<User1> convert = convert(users, a -> new User1(a.getAge()));
        System.out.println(convert);
    }

    public static <T,R> List<R> convert(List<T> list,
                                        FunctionProcess<T,R> processor){
        List<R> result = Lists.newArrayList();
        list.stream().forEach(a->result.add(processor.apply(a)));
        return result;
    }

    private static void testConsumer() {
        List<User> users = init();
        forEach(users,user->{
            if(user.getAge()>5){
                System.out.println(user);
            }
        });

    }

    public static <T> void forEach(List<T> list, ConsumerProcessor<T> con){
        for (T t : list) {
            con.accept(t);
        }
    }

    private static void testFileReader() throws IOException {
        String text = processFile((br) -> {
            StringBuffer result = new StringBuffer();
            String s;
            while ((s = br.readLine()) != null) {
                result.append(s + "\n");
            }

            return result.toString();
        }, "D:/test.txt");
        System.out.println(text);
    }


    public static String processFile(BufferedReaderProcessor processor, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return processor.process(reader);
        }
    }
}
