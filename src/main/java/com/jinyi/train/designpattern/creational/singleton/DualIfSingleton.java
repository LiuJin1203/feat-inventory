package com.jinyi.train.designpattern.creational.singleton;

/**
 * @author liujin
 * @date 2019/10/30
 * @since JDK8
 */
public class DualIfSingleton {
  //增加volatile修饰多线程模式下禁止[分配内存空间]和[初始化对象]重排序
  private volatile static DualIfSingleton instance = null;
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
