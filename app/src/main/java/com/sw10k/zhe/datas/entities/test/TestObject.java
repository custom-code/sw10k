package com.sw10k.zhe.datas.entities.test;

import com.sw10k.zhe.views.activities.base.entities.Sw10kObject;

/**
 * Created by zhe on 16/1/14.
 */
public class TestObject extends Sw10kObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
