package com.jinyi.train.creational.factory;

import java.util.Arrays;

/**
 * @author liujin
 * @date 2019/10/29
 * @since JDK8
 */
public class DualPivotQuicksortProduct implements SortProduct {

  public void sort(int[] array) {
    Arrays.sort(array);
  }
}
