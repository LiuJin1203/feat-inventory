package com.jinyi.train.designpattern.behavioral.visitor;


/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public interface ComputerPartVisitor {
  public void visit(AbstractComputerPart computerPart);
}
