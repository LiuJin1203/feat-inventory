package com.jinyi.train.structural.proxy;

/**
 * @author liujin
 * @date 2019/8/13
 * @since JDK8
 */
public class RealSubject implements Subject {

  @Override
  public void request() {
    System.out.println("real subject.");
  }

  @Override
  public void hello() {
    System.out.println("hello::real subject.");
  }
}
