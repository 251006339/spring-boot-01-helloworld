package com.hxm.springboot01helloworld.exception;

/**
 * @author XAIOHU
 * @date 2019/9/10 --10:46
 **/
public class UserNotExistException extends  RuntimeException {
    public UserNotExistException() {
        super("用户不存在"); //回调消息不存在;

    }


}
