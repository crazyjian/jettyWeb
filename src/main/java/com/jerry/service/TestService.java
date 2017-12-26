package com.jerry.service;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import com.jerry.bean.TestBean;

/**
 * Created by hujian on 2017/12/26
 */
@ThriftService
public interface TestService {

    @ThriftMethod
    public void setBean(TestBean bean);
    @ThriftMethod
    public TestBean getBean();
    @ThriftMethod
    public String sayHello(String str);
    @ThriftMethod
    public TestBean updateBean(TestBean bean);

}
