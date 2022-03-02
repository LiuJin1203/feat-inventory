package com.jinyi.train.dsl.function.inter;


import com.jinyi.train.dsl.function.vo.IPVO;
import com.jinyi.train.dsl.function.vo.PostalCodeVO;

/**
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public interface IIpToPostalCode {
    PostalCodeVO baseOn(IPVO ip);

}
