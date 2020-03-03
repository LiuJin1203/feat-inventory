package com.jinyi.train.designpattern.structural.proxy;

/**
 * @author liujin
 * @date 2019/8/13
 * @since JDK8
 */
public class ProxySubject implements Subject {

  private RealSubject realSubject;

  public ProxySubject(RealSubject realSubject) {
    this.realSubject = realSubject;
  }

  @Override
  public void request() {
    System.out.println("proxy: before.");
    try {
      realSubject.request();
    }catch (Exception e){
      System.out.println("ex:"+e.getMessage());
      throw e;
    }finally {
      System.out.println("proxy: after.");
    }
  }

  @Override
  public void hello() {
    System.out.println("proxy: before.");
    try {
      realSubject.hello();
    }catch (Exception e){
      System.out.println("ex:"+e.getMessage());
      throw e;
    }finally {
      System.out.println("proxy: after.");
    }
  }
}
