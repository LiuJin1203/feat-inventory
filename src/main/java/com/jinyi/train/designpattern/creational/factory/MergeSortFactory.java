package com.jinyi.train.designpattern.creational.factory;

/**
 * @author liujin
 * @date 2019/10/29
 * @since JDK8
 */
public class MergeSortFactory implements IFactory {

  @Override
  public SortProduct create() {
    return new MergeSortProduct();
  }
}
