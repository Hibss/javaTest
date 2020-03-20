package com.syz.java.test.hashCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author steven.sheng
 * @Date 2018/11/26/026.
 */
public class TestHashCodeEquals {
    public static void main(String[] args) {
        User a = User.builder()
                .name("张三")
                .build(),
                b = User.builder()
                        .name("张三")
                        .build();
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        LinkedList<User> list = new LinkedList<>();
        Set<User> set = new HashSet<>();
        list.add(a);
        list.add(b);
        System.out.println("list size:"+ list.size());

        set.add(a);
        set.add(b);
        System.out.println("set size:"+ set.size());
        a.setName("123");
        System.out.println("set remove stu1 : "+set.remove(a));
        System.out.println("list remove stu1 : "+list.remove(a));
        System.out.println("set size:"+ set.size());

        int aa = 5;
        boolean bb= true;
        boolean ff = (bb = 6 == aa)?false:true;
        System.out.println(bb);
        System.out.println(ff);
        System.out.println(aa);
    }
}
