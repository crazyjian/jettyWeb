package com.jerry.bean;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

/**
 * Created by hujian on 2017/12/26
 */
@ThriftStruct
public class TestBean {

    private Integer id;
    public TestBean() {
    }
    @ThriftField(1)
    public Integer getId() {
        return id;
    }
    @ThriftField
    public void setId(Integer id) {
        this.id = id;
    }
}

