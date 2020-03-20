package com.syz.java.test.resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author steven.sheng
 * @Date 2018/12/7/007.
 */
public class TestResourceBundle {
    public static void main(String[] args) {

        Locale locale = new Locale("zh","CN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("myres",locale);
        System.out.println(resourceBundle.getString("aaa"));
        System.out.println(resourceBundle.getString("bbb"));

        ResourceBundle resb2 = ResourceBundle.getBundle("myres", Locale.getDefault());
        System.out.println(resb2.getString("aaa"));
        System.out.println(resb2.getString("bbb"));

        Locale locale3 = new Locale("en", "US");
        ResourceBundle resb3 = ResourceBundle.getBundle("myres", locale3);
        System.out.println(resb3.getString("aaa"));
        System.out.println(resb3.getString("bbb"));
    }
}
