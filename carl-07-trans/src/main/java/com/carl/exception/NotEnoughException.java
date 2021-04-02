package com.carl.exception;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/13:54
 * @Description: 自定义的运行时异常类
 */
public class NotEnoughException extends RuntimeException{
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
