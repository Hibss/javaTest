package com.syz.java.test.biz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author steven.sheng
 * @Date 2019/2/13/013.
 */
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 8078775191180026820L;
    private String name;
    private Integer age;
    private Integer id;


}
