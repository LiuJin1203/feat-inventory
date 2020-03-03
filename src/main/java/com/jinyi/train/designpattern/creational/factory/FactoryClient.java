package com.jinyi.train.designpattern.creational.factory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liujin
 * @date 2019/10/29
 * @since JDK8
 */
public class FactoryClient {

  public static void main(String[] args) {
    simpleFactoryClient();
    factoryClient();
    absFactoryClient();

  }

  private static void absFactoryClient() {
    int[] a = {1,5,3,8,2,9,6,8,7,4};

    IFactory factory = new MergeSortFactory();
    SortProduct product =factory.create();
    product.sort(a);
    System.out.println(Arrays.toString(a));
  }

  private static void factoryClient() {
    int[] a = {1,5,3,8,2,9,6,8,7,4};
    DualPivotQuickSortFactory factory = new DualPivotQuickSortFactory();
    Type type = factory.getClass().getGenericSuperclass();
    SortProduct product =factory.create();
    product.sort(a);
    List list = new ArrayList<>();

    System.out.println(Arrays.toString(a));
  }

  private static void simpleFactoryClient() {
    int[] a = {1,5,3,8,2,9,6,8,7,4};
    SimpleFactory factory = new SimpleFactory();
    SortProduct product = factory.create("simple");
    product.sort(a);
    System.out.println(Arrays.toString(a));
  }
}
