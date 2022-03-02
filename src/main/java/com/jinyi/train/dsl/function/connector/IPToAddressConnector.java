package com.jinyi.train.dsl.function.connector;


import com.jinyi.train.dsl.function.func.IPToAddressFunc;

/**
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public interface IPToAddressConnector {
    AddressToPostalCodeConnector use(IPToAddressFunc ipToAddressFunc);
}
