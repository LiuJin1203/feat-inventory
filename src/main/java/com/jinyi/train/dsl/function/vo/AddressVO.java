package com.jinyi.train.dsl.function.vo;

/**
 * 通讯地址
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public class AddressVO {
    private final String location;

    public AddressVO(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
