package com.jinyi.train.structural.proxy.cglib;


import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author liujin
 * @date 2019/8/17
 * @since JDK8
 */
public class DemoMethodInterceptor implements MethodInterceptor {

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    System.out.println("cglib-proxy: before.");
    Throwable ex = new Throwable();
    StackTraceElement[] stackElements = ex.getStackTrace();
    Object result = null;
    try {
      result = methodProxy.invokeSuper(o,objects);
    }catch (Exception e){
      System.out.println("ex:"+e.getMessage());
      throw e;
    }finally {
      System.out.println("cglib-proxy: after.");
    }
    return result;
  }
}
