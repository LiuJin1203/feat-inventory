package com.jinyi.train.behavioral.template;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class TemplatePatternDemo {
  public static void main(String[] args) {

    Game game = new Cricket();
    game.play();
    System.out.println();
    game = new Football();
    game.play();
  }
}