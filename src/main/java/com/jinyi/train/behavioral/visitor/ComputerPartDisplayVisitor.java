package com.jinyi.train.behavioral.visitor;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

  @Override
  public void visit(AbstractComputerPart computerPart) {
    System.out.println(computerPart.getClass().getSimpleName()+" displaying ...");
  }
}
