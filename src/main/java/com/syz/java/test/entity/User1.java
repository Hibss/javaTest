package com.syz.java.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author steven.sheng
 * @Date 2020/3/9/00915:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User1 implements Serializable{

    private static final long serialVersionUID = 3288606147771197018L;
    private Integer age;
}
