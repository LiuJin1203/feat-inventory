package com.jinyi.train.designpattern.creational.builder;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class EmployeeTest {
  public static void main(String[] args) {
    Employee employee = new Employee.EmployeeBuilder("Cristiano", "Ronaldo", 33, 7)
        .setPhone("0045-1234556")
        .setAddress("Juventus")
        .setMail("CR@Juventus.org").build();
    System.out.println(employee.toString());
  }
}
