package com.jinyi.train.behavioral.interpreter;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class TerminalExpression implements Expression {

  private String data;

  public TerminalExpression(String data){
    this.data = data;
  }

  @Override
  public boolean interpret(String context) {
    if(context.contains(data)){
      return true;
    }
    return false;
  }
}
