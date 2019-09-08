package com.imooc.demo.utils;

import com.imooc.demo.domain.Result;

/**
 * Create By yuanyuan on 2019/9/7 19:24
 */
public class ResultUtil {

    public static <T>  Result success(T object) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("ok");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
