package com.jinyi.train.structural.bridge;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public abstract class AbstractColor implements Color {

  @Override
  public String paint(Shape shape) {
    return this.getClass().getSimpleName()+"::"+shape.getClass().getSimpleName();
  }
}
