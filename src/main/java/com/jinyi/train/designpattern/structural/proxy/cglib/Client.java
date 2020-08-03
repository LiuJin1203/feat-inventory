package com.jinyi.train.designpattern.structural.proxy.cglib;


import com.jinyi.train.designpattern.structural.proxy.RealSubject;
import com.jinyi.train.designpattern.structural.proxy.Subject;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author liujin
 * @date 2019/8/17
 * @since JDK8
 */
public class Client {

  public static void main(String[] args) {
    partOne();
    partTwo();
  }

  private static void partTwo() {
    System.getProperties().put(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\workspace\\integration-testing\\aop-guide\\test");
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\workspace\\integration-testing\\aop-guide\\test");

    RealSubject subject1 = (RealSubject) Enhancer.create(RealSubject.class,new DemoMethodInterceptor());
    subject1.hello();
  }

  private static void partOne() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(RealSubject.class);
    enhancer.setCallback(new DemoMethodInterceptor());
    RealSubject subject = (RealSubject) enhancer.create();
    subject.hello();
  }
}
