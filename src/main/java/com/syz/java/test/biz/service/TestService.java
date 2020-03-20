package com.syz.java.test.biz.service;

import com.syz.java.test.biz.dao.UserMapper;
import com.syz.java.test.biz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author steven.sheng
 * @Date 2019/2/13/013.
 */
@Service
public class TestService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insert(Integer id, Integer age, String name) {
        try {
            User user = new User();
            user.setAge(age);
            user.setId(id);
            user.setName(name);
            userMapper.insert(user);
            if (id == 3) {
                id = 1 / 0;// 此处会产生异常
            }
        } catch (Exception ex) {
            System.out.println(id + "service异常日志处理");
            throw new RuntimeException(ex);
        }
        System.out.println(id + "service正常执行");
    }
}
