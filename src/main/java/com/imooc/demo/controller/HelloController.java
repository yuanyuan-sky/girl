package com.imooc.demo.controller;

import com.imooc.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Create By yuanyuan on 2019/9/7 10:00
 */
//将@Controller注解与Ajax请求方法上的@ResponseBody注解合并，这样放上上就不需要@ResponseBody
//Spring4新加的注解
@RestController
public class HelloController {

    /*读取配置文件中的属性*/
    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    //这两个url都可以访问这个方法
    //@RequestMapping(value ={"/hello/{id}","/hi"} ,method = RequestMethod.GET)
    //@PathVariable  获取请求路径里的值
    //@RequestParam 获取请求参数，问好后面的。可以设置是否是必传的，以及默认值是多少
    //接受get请求
    @GetMapping(value = "/hello/{id}")
    //@PostMapping
    //@PutMapping
    //@DeleteMapping
    public String say(@PathVariable("id") Integer id) {
        return id.toString();
    }


}
