package com.jinyi.train.structural.facade;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class CPU implements Component{

  public void startup(){
    System.out.println("cpu startup!");
  }
  public void shutdown(){
    System.out.println("cpu shutdown!");
  }

}
