package com.syz.java.test.java8.filter;

import com.google.common.collect.Lists;
import com.syz.java.test.entity.User;
import com.syz.java.test.entity.predicate.UserPredicate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author steven.sheng
 * @Date 2020/3/9/00915:31
 */
public class FilterTest {
    private static int size = 10;

    public static List<User> init(){
        List<User> users = Lists.newArrayListWithCapacity(size);
        for (Integer i = 0; i < size; i++) {
            User user = new User(i,i.toString() + "name");
            User user1 = new User(i,i.toString() + "name");
            users.add(user);
            users.add(user1);
        }
        return users;
    }

    public static void main(String[] args) {
        List<User> users = FilterTest.init();
        System.out.println(users);
        filter(users);
//        anonymousFilter(users);
//        groupMap(users);
    }

    private static void groupMap(List<User> users) {
        Map<Integer,List<User>> userMap = users.stream().filter(a->a.getAge() > 5)
                .collect(Collectors.groupingBy(User::getAge));
        System.out.println(userMap);
    }

    private static void anonymousFilter(List<User> users) {
        List<User> users1 = filterUser(users, (User a) -> a.getAge() > 5);
        System.out.println("-------------");
        System.out.println(users1);
    }


    private static void filter(List<User> users) {
        List<User> users1 = filterUser(users, User::testAge);
        System.out.println("----------------");
        System.out.println(users1);
        List<User> users2 = filterUser(users1, User::testName);
        System.out.println("===================");
        System.out.println(users2);
    }
    static List<User> filterUser(List<User> users, UserPredicate<User> predicate){
        List<User> userList = Lists.newArrayListWithCapacity(users.size());
        for (User user : users) {
            if(predicate.test(user)){
                userList.add(user);
            }
        }
        return userList;
    }
}
