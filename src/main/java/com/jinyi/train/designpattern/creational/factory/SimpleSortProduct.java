package com.jinyi.train.designpattern.creational.factory;

import java.util.Arrays;

/**
 * @author liujin
 * @date 2019/10/28
 * @since JDK8
 */
public class SimpleSortProduct implements SortProduct {

  public void sort(int[] array) {
    Arrays.sort(array);
  }
}
