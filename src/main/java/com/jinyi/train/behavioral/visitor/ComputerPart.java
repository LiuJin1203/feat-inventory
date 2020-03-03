package com.jinyi.train.behavioral.visitor;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public interface ComputerPart {
  public void accept(ComputerPartVisitor computerPartVisitor);
}
