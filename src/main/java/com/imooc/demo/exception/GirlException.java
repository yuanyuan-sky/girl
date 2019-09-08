package com.imooc.demo.exception;

import com.imooc.demo.enums.ResultEnum;

/**
 * 定义自己的异常，要继承RuntimeException，因为Spring的事务回滚只发生在RuntimeException
 * Create By yuanyuan on 2019/9/7 19:58
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
