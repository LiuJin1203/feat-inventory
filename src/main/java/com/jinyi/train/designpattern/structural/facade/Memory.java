package com.jinyi.train.designpattern.structural.facade;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class Memory implements Component{
  public void startup(){
    System.out.println("memory startup!");
  }
  public void shutdown(){
    System.out.println("memory shutdown!");
  }
}
