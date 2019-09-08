package com.imooc.demo;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create By yuanyuan on 2019/9/7 20:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTests {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() {
        Girl girl = girlService.findOne(2);
        Assert.assertEquals(new Integer(8), girl.getAge());
    }
}
