package com.jinyi.train.dsl.function.func;


import com.jinyi.train.dsl.function.vo.AddressVO;
import com.jinyi.train.dsl.function.vo.IPVO;

import java.util.function.Function;

/**
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public interface IPToAddressFunc extends Function<IPVO, AddressVO> {
    IPToAddressFunc dalian = ip -> new AddressVO("大连");


}
