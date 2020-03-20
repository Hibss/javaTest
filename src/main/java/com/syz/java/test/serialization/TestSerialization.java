package com.syz.java.test.serialization;

import com.syz.java.test.util.GsonUtil;

import java.io.*;

/**
 * @Author steven.sheng
 * @Date 2018/11/23/023.
 */
public class TestSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializationUser();
        User user = deSerializationUser();
        System.out.println(GsonUtil.GsonString(user));
    }

    private static User deSerializationUser() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/TestSerialization.txt")));
        User person = (User) ois.readObject();
        System.out.println("User对象反序列化成功！");
        return person;
    }

    private static void serializationUser() throws IOException {
        User user = User.builder().age(999).address("广寒宫").name("嫦娥").build();
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/TestSerialization.txt")));
        oo.writeObject(user);
        System.out.println("User序列化输出到E:/TestSerialization.txt！");
        oo.close();
    }


}
