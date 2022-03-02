package com.jinyi.train.dsl.function.connector;


import com.jinyi.train.dsl.function.func.AddressToPostalCodeFunc;
import com.jinyi.train.dsl.function.inter.IIpToPostalCode;

/**
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public interface AddressToPostalCodeConnector {
    IIpToPostalCode use(AddressToPostalCodeFunc addressToPostalCodeFunc);
}
