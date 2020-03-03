package com.jinyi.train.designpattern.structural.facade;

/**
 * https://www.runoob.com/w3cnote/facade-pattern-2.html
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class FacadeDemo {

  public static void main(String[] args) {
    Computer computer = new Computer();
    computer.startup();
    computer.shutdown();
  }
}
