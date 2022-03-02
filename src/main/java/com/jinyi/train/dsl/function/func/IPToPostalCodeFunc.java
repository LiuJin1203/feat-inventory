package com.jinyi.train.dsl.function.func;



import com.jinyi.train.dsl.function.vo.IPVO;
import com.jinyi.train.dsl.function.vo.PostalCodeVO;

import java.util.function.Function;

/**
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public class IPToPostalCodeFunc implements Function<IPVO, PostalCodeVO> {
    @Override
    public PostalCodeVO apply(IPVO ipvo) {
        IPToAddressFunc ipToAddressFunc = IPToAddressFunc.dalian;
        AddressToPostalCodeFunc addressToPostalCodeFunc = AddressToPostalCodeFunc.dalian;
        return  ipToAddressFunc.andThen(addressToPostalCodeFunc).apply(ipvo);
    }
}
