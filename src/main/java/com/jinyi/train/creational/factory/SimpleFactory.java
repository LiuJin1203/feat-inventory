package com.jinyi.train.creational.factory;

/**
 *
 * @author liujin
 * @date 2019/10/28
 * @since JDK8
 */
public class SimpleFactory {

  public SortProduct create(String productType){
    SortProduct product = null;
    switch (productType){
      case "simple":
        product = new SimpleSortProduct();break;
      case "dualQuick":
        product = new DualPivotQuicksortProduct();break;
    }
    return product;
  }
}
