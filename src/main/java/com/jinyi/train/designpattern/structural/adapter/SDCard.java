package com.jinyi.train.designpattern.structural.adapter;

/**
 * @author liujin
 * @date 2019/10/30
 * @since JDK8
 */
public class SDCard {
  private String type = this.getClass().getSimpleName();
  private String sdContext = type;
  //读取SD卡方法
  public String readSD(){
    return sdContext;
  }
  //写入SD卡功能
  void writeSD(String msg){
    sdContext = type+"::"+msg;
  }
}
