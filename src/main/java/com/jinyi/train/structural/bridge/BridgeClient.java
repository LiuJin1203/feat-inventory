package com.jinyi.train.structural.bridge;

/**
 * @author liujin
 * @date 2019/10/31
 * @since JDK8
 */
public class BridgeClient {


  public static void main(String[] args) {
    Shape shape = new Square();
    Shape shape2 = new Triangle();
    Color color = new RedColor();
    Color color2 = new GreenColor();
    shape.setColor(color);
    shape2.setColor(color2);
    String d = shape.draw();
    String d2 = shape2.draw();

    System.out.println(d);
    System.out.println(d2);
  }

}
