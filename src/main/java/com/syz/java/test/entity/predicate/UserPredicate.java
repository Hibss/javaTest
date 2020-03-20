package com.syz.java.test.entity.predicate;

/**
 * @Author steven.sheng
 * @Date 2020/3/9/00915:28
 */
public interface UserPredicate<T> {

    Boolean test(T a);

}
