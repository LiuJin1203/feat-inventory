package com.jinyi.train.structural.proxy;

/**
 * @author liujin
 * @date 2019/8/13
 * @since JDK8
 */
public class ProxyClientDemo {

  public static void main(String[] args) {
    Subject subject = new ProxySubject(new RealSubject());
    subject.request();
  }
}
