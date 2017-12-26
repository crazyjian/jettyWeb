package com.jerry.service.impl;

import com.jerry.bean.TestBean;
import com.jerry.service.TestService;

/**
 * Created by hujian on 2017/12/26
 */
public class TestServiceImpl implements TestService {



    @Override
    public void setBean(TestBean bean) {

    }

    @Override
    public TestBean getBean() {
        TestBean bean = new TestBean();
        bean.setId(1000);
        return bean;
    }

    @Override
    public String sayHello(String str) {
        return "你好："+str;
    }

    @Override
    public TestBean updateBean(TestBean bean) {
        bean.setId(2000);
        return bean;
    }
}
