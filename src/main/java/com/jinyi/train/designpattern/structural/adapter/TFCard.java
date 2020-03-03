package com.jinyi.train.designpattern.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/30
 * @since JDK8
 */
public class TFCard {
  private String type = this.getClass().getSimpleName();
  private String tfContext = type;
  //读取SD卡方法
  public String readTF(){
    return tfContext;
  }
  //写入SD卡功能
  void writeTF(String msg){
    tfContext = type+"::"+msg;
  }
}
