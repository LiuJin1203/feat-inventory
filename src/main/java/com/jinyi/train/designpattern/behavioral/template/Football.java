package com.jinyi.train.designpattern.behavioral.template;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class Football extends Game {

  @Override
  void endPlay() {
    System.out.println("Football Game Finished!");
  }

  @Override
  void initialize() {
    System.out.println("Football Game Initialized! Start playing.");
  }

  @Override
  void startPlay() {
    System.out.println("Football Game Started. Enjoy the game!");
  }
}
