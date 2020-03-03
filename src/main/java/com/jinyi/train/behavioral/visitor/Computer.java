package com.jinyi.train.behavioral.visitor;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class Computer extends AbstractComputerPart {
  ComputerPart[] parts;

  public Computer(){
    parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
  }


  @Override
  public void accept(ComputerPartVisitor computerPartVisitor) {
    for (int i = 0; i < parts.length; i++) {
      parts[i].accept(computerPartVisitor);
    }
    computerPartVisitor.visit(this);
  }
}
