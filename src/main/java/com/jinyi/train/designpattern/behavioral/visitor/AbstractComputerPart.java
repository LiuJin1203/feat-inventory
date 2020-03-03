package com.jinyi.train.designpattern.behavioral.visitor;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public abstract class AbstractComputerPart implements ComputerPart {

  @Override
  public void accept(ComputerPartVisitor computerPartVisitor) {
    computerPartVisitor.visit(this);
  }

  class Keyboard extends AbstractComputerPart{

  }

  class Mouse extends AbstractComputerPart{

  }

  class Monitor extends AbstractComputerPart{

  }

}
