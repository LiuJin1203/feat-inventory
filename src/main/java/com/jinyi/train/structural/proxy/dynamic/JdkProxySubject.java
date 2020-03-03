package com.jinyi.train.structural.proxy.dynamic;

import com.jinyi.train.structural.proxy.RealSubject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liujin
 * @date 2019/8/15
 * @since JDK8
 */
public class JdkProxySubject implements InvocationHandler {

  RealSubject realSubject ;

  public JdkProxySubject(RealSubject realSubject) {
    this.realSubject = realSubject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("jdk-proxy: before.");
    Object result = null;
    try {
      result = method.invoke(realSubject,args);
    }catch (Exception e){
      System.out.println("ex:"+e.getMessage());
      throw e;
    }finally {
      System.out.println("jdk-proxy: after.");
    }
    return result;
  }
}
