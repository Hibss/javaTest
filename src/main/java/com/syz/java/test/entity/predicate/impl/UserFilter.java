package com.syz.java.test.entity.predicate.impl;

import com.syz.java.test.entity.User;
import com.syz.java.test.entity.predicate.UserPredicate;

/**
 * @Author steven.sheng
 * @Date 2020/3/9/00915:29
 */
public class UserFilter implements UserPredicate<User> {
    @Override
    public Boolean test(User a) {
        return a != null;
    }
}
