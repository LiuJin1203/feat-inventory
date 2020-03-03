package com.jinyi.train.structural.bridge;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public abstract class Shape {
  Color color;

  public void setColor(Color color) {
    this.color = color;
  }

  public abstract String draw();
}
