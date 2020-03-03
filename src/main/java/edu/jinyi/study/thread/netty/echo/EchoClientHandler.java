package edu.jinyi.study.thread.netty.echo;

import edu.jinyi.study.thread.netty.discard.DiscardClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author liujin
 * @date 2019/11/5
 * @since JDK8
 */
@Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks! @"+System.currentTimeMillis(), CharsetUtil.UTF_8));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    // Close the connection when an exception is raised.
    cause.printStackTrace();
    ctx.close();
  }

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) throws Exception {
    System.out.println("Client received:"+in.toString(CharsetUtil.UTF_8));
  }
}
