package com.jerry.service.impl;

import com.jerry.service.HelloWorldService;
import org.apache.thrift.TException;

/**
 * Created by hujian on 2017/12/26
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {


    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " ,Welcome to the thrift's world !";
    }
}
