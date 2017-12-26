package com.jerry.client;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.google.common.net.HostAndPort;
import com.jerry.bean.TestBean;
import com.jerry.service.TestService;
import org.apache.thrift.TException;

import java.util.concurrent.ExecutionException;

/**
 * Created by hujian on 2017/12/26
 */
public class TestClientDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TException {

        ThriftClientManager clientManager = new ThriftClientManager();
        TestService testService = clientManager.createClient(
                new FramedClientConnector(HostAndPort.fromParts("localhost", 8090)),
                TestService.class).get();
        System.out.println(testService.sayHello("jim111"));
        TestBean bean = new TestBean();
        bean.setId(10001);
        System.out.println("传输前ID："+bean.getId());
        System.out.println("传输后ID："+testService.updateBean(bean).getId());

    }
}
