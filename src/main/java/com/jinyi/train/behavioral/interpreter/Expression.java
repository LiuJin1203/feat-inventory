package com.jinyi.train.behavioral.interpreter;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public interface Expression {
  public boolean interpret(String context);
}
