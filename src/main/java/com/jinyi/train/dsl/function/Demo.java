package com.jinyi.train.dsl.function;


import com.jinyi.train.dsl.function.func.AddressToPostalCodeFunc;
import com.jinyi.train.dsl.function.func.IPToAddressFunc;
import com.jinyi.train.dsl.function.inter.IIpToPostalCode;
import com.jinyi.train.dsl.function.vo.AddressVO;
import com.jinyi.train.dsl.function.vo.IPVO;

/**
 * @author liujin
 * @date 2022/2/15
 * @since JDK8
 */
public class Demo {
    public static void main(String[] args) {
        IPVO ip = new IPVO("127.0.0.1");
//        PostalCodeVO postalCode =
                IIpToPostalCode ipToPostalCode =
                IpToPostalCodeCombinator.combine()
                .use(liaoning)
                .use(AddressToPostalCodeFunc.dalian)
//                .baseOn(ip)
                ;
        System.out.println(ipToPostalCode.baseOn(ip));

    }

    public static IPToAddressFunc liaoning = ipvo -> new AddressVO("辽宁");
}
