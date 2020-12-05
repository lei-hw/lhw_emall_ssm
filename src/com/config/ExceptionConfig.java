package com.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一处理业务异常 controller
 */
@ControllerAdvice
public class ExceptionConfig {
    /**
     * 业务异常
     */
    @ExceptionHandler(MyException.class)
    public String exception(MyException exception, HttpServletRequest request){
        request.setAttribute("msg",exception.getMessage());
        return "/index/error.jsp";
    }

    /**
     * 默认异常
     */
    @ExceptionHandler(Exception.class)
    public String exception(Exception exception, HttpServletRequest request){
        request.setAttribute("msg","系统错误");
        return "/index/error.jsp";
    }

    /**
     * 自定义异常
     */
    public static class MyException extends Exception{
        public MyException(String msg) {super((msg));}
    }
}
