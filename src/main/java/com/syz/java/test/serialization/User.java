package com.syz.java.test.serialization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author steven.sheng
 * @Date 2018/11/23/023.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = -4300781835762221257L;

    private String name;
    private String address;
    private Integer age;

}
