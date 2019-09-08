package com.imooc.demo.controller;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.domain.Result;
import com.imooc.demo.respository.GirlRepository;
import com.imooc.demo.service.GirlService;
import com.imooc.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Create By yuanyuan on 2019/9/7 14:18
 */
@RestController
public class GirlController {

    private final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("我是被切的人");
        List<Girl> list = girlRepository.findAll();
        return list;
    }

    /**
     * 添加一个女生
     * @param
     * @param
     * @return
     */
    @PostMapping(value = "/girls")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) {

        Girl girl1 = new Girl();
        if (bindingResult.hasErrors()) {
            return null;
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl1.setAge(girl.getAge());
        girl1.setCupSize(girl.getCupSize());
        return ResultUtil.success(girlRepository.save(girl1));
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Object getGirl(@PathVariable("id") Integer id) {
        Result<Girl> result = new Result<>();
        try {
            Girl girl = girlRepository.findById(id).get();
            return ResultUtil.success(girl);
        } catch (Exception e) {
            return ResultUtil.success();
        }
    }

    /**
     * 修改数据
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除数据
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        List<Girl> list = girlRepository.findByAge(age);
        return list;
    }

    @PostMapping(value = "girls/insertTwo")
    public void insetTwoGirl() {
        girlService.insertTwo();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
