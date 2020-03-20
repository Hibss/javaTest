package com.syz.java.test.locale;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author steven.sheng
 * @Date 2018/12/7/007.
 */
public class TestLocale {
    public static void main(String[] args) {
        //查看系统支持的语言和国家代码
        System.out.println("查看语言、国家代码");
        Locale[] locales = Locale.getAvailableLocales();
        Locale traditionalChinese = Locale.TRADITIONAL_CHINESE;
        for(Locale locale: locales){
            System.out.println(locale.getDisplayLanguage() +"---->"+locale.getLanguage());
            System.out.println(locale.getDisplayCountry() +"---->"+locale.getCountry());
        }

        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println("查看properties");
        //Locale locale = Locale.getDefault(Locale.Category.FORMAT);
        //指定Locale为US
        //指定myres文件,
        ResourceBundle bundle = ResourceBundle.getBundle("myres",Locale.US);
        System.out.println("aaa"+bundle.getString("aaa"));
        bundle = ResourceBundle.getBundle("myres",traditionalChinese);
        System.out.println(bundle.getString("aaa"));
        bundle = ResourceBundle.getBundle("myres");
        System.out.println(bundle.getString("aaa"));
    }
}
