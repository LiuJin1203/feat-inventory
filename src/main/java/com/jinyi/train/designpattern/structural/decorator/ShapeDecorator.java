package com.jinyi.train.designpattern.structural.decorator;

/**
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public abstract class ShapeDecorator implements Shape {
  protected Shape decoratedShape;
  public ShapeDecorator(Shape decoratedShape) {
    super();
    this.decoratedShape = decoratedShape;
  }
}
