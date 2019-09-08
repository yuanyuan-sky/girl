package com.imooc.demo.service;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.enums.ResultEnum;
import com.imooc.demo.exception.GirlException;
import com.imooc.demo.respository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Create By yuanyuan on 2019/9/7 15:41
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(6);
        girlA.setCupSize("b");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(7);
        girlB.setCupSize("aaaaaaaaaa");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if (age < 10) {
            //返回你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else {
            throw new GirlException(ResultEnum.NO_SCHOOL);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findById(id).get();
    }
}
