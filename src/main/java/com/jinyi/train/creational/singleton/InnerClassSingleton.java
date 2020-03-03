package com.jinyi.train.creational.singleton;

/**
 * @author liujin
 * @date 2019/10/30
 * @since JDK8
 */
public class InnerClassSingleton {

  private InnerClassSingleton() {
  }

  private static class SingleHolder{
    public static InnerClassSingleton instance = new InnerClassSingleton();
  }

  public static InnerClassSingleton getInstance(){
    return SingleHolder.instance;
  }
}
