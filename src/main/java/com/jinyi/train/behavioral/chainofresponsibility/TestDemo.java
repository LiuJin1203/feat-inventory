package com.jinyi.train.behavioral.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * https://dzone.com/articles/chain-of-responsibility-design-pattern-in-java-2-i
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class TestDemo {

  public static void main(String[] args) {
    RequestData requestData = new RequestData();
    List< RequestHandler > requestHandlers = new ArrayList< >();
    requestHandlers.add(new DBDataHandler());
    requestHandlers.add(new FileDataHandler());
    requestHandlers.add(new CloudDataHandler());
    // create the chain of Handler
    for (int i = 0; i < requestHandlers.size() - 1; i++) {
      requestHandlers.get(i).setNextRequestHandler(requestHandlers.get(i + 1));
    }
    requestHandlers.get(0).process(requestData);
    System.out.println(requestData);
  }
}
