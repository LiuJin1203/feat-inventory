package com.jinyi.train.dsl.function;


import com.jinyi.train.dsl.function.connector.IPToAddressConnector;

/**
 * ip->PostalCode 组合子
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public class IpToPostalCodeCombinator {
    public static IPToAddressConnector combine() {
        return ipToAddressFunc -> addressToPostalCodeFunc -> ip -> ipToAddressFunc.andThen(addressToPostalCodeFunc).apply(ip);
    }
}
