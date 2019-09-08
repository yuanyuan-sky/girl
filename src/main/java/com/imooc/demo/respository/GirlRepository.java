package com.imooc.demo.respository;

import com.imooc.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄来查询,方法名必须这样命名
    public List<Girl> findByAge(Integer age);

}
