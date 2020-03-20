package com.syz.java.test.biz.dao;

import com.syz.java.test.biz.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author steven.sheng
 * @Date 2019/2/13/013.
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(id,age,name) values(#{id},#{age},#{name})")
    void insert(User user);
}
