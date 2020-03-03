package com.jinyi.train.structural.proxy.cglib;


import com.jinyi.train.structural.proxy.RealSubject;
import com.jinyi.train.structural.proxy.Subject;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author liujin
 * @date 2019/8/17
 * @since JDK8
 */
public class Client {

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(RealSubject.class);
    enhancer.setCallback(new DemoMethodInterceptor());
    Subject subject = (Subject) enhancer.create();
    subject.hello();
  }
}
