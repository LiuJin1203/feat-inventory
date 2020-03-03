package com.jinyi.train.behavioral.chainofresponsibility;

/**
 * @author liujin
 * @date 2019/11/9
 * @since JDK8
 */
public class DBDataHandler implements RequestHandler {
  private RequestHandler requestHandler;
  @Override
  public void setNextRequestHandler(RequestHandler requestHandler) {
    this.requestHandler = requestHandler;
  }
  @Override
  public boolean process(RequestData requestData) {
    requestData.setMetaDBData("Meta Data from DB is populated");
    return requestHandler == null ? true : requestHandler.process(requestData);
  }
}
