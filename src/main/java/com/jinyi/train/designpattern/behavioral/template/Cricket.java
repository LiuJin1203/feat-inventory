package com.jinyi.train.designpattern.behavioral.template;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class Cricket extends Game {

  @Override
  void endPlay() {
    System.out.println("Cricket Game Finished!");
  }

  @Override
  void initialize() {
    System.out.println("Cricket Game Initialized! Start playing.");
  }

  @Override
  void startPlay() {
    System.out.println("Cricket Game Started. Enjoy the game!");
  }
}