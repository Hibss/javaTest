package com.syz.java.test.biz;

import com.syz.java.test.biz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author steven.sheng
 * @Date 2019/2/13/013.
 */
@Component
public class TestBiz {

    @Autowired
    private TestService testService;

    @Transactional
    public void testInsert(){
        for (int i=0;i<10;i++) {
            testService.insert(null,i,"姓名"+System.currentTimeMillis());
        }
    }
}
