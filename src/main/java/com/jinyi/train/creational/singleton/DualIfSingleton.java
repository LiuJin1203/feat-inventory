package com.jinyi.train.creational.singleton;

/**
 * @author liujin
 * @date 2019/10/30
 * @since JDK8
 */
public class DualIfSingleton {
  private static DualIfSingleton instance = null;
  private DualIfSingleton(){

  }

  public static DualIfSingleton getInstance(){
    if (instance==null){
      synchronized (DualIfSingleton.class){
        if (instance==null){
          instance = new DualIfSingleton();
        }
      }
    }
    return instance;
  }

}
