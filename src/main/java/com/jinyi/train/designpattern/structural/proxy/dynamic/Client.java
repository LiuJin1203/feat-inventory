package com.jinyi.train.designpattern.structural.proxy.dynamic;

import com.jinyi.train.designpattern.structural.proxy.RealSubject;
import com.jinyi.train.designpattern.structural.proxy.Subject;
import java.lang.reflect.Proxy;

/**
 * @author liujin
 * @date 2019/8/15
 * @since JDK8
 */
public class Client {

  public static void main(String[] args) {
//    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
    Subject subject = (Subject)Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
    subject.request();
    subject.hello();
  }
}
