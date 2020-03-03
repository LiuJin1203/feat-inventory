package com.jinyi.train.designpattern.behavioral.visitor;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class VisitorPatternDemo {
  public static void main(String[] args) {

    ComputerPart computer = new Computer();
    ComputerPartVisitor computerPartVisitor = new ComputerPartDisplayVisitor();
    computer.accept(computerPartVisitor);
  }
}
