package com.jinyi.train.designpattern.behavioral.command;

/**
 * @author liujin
 * @date 2019/11/22
 * @since JDK8
 */
public class Stock {

  private String name = "ABC";
  private int quantity = 10;

  public void buy(){
    System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
  }
  public void sell(){
    System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
  }
}
