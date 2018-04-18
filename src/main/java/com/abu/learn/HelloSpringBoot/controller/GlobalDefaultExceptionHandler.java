package com.abu.learn.HelloSpringBoot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    /**
     * 处理 Exception 类型的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> defaultExceptionHandler(Exception e) {
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        return map;
    }
}