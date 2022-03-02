package com.jinyi.train.dsl.function.vo;

/**
 * 邮政编码
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public class PostalCodeVO {
    private final String v;

    public PostalCodeVO(String v) {
        this.v = v;
    }

    public String getV() {
        return v;
    }

    @Override
    public String toString() {
        return "PostalCodeVO{" +
                "v='" + v + '\'' +
                '}';
    }
}
