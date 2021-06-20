package com.dutu.admin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web的异常
 * @author dutu
 * @date 2021-03-05 20:15
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleArithException(){

        return "login";
    }
}
