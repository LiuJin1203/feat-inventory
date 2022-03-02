package com.jinyi.train.dsl.function.func;



import com.jinyi.train.dsl.function.vo.AddressVO;
import com.jinyi.train.dsl.function.vo.PostalCodeVO;

import java.util.function.Function;

/**
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public interface AddressToPostalCodeFunc extends Function<AddressVO, PostalCodeVO> {
     AddressToPostalCodeFunc dalian = addressVO -> new PostalCodeVO("121000");

}
