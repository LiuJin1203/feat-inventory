package com.jinyi.train.netty.echo;

/**
 * @author liujin
 * @date 2019/11/5
 * @since JDK8
 */

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;

/**
 * Discards any incoming data.
 */
public class EchoServer {

  private final int port;

  public EchoServer(int port) {
    this.port = port;
  }

  public void start() throws Exception {
    final EchoServerHandler serverHandler = new EchoServerHandler();
    EventLoopGroup group = new NioEventLoopGroup(); // (1)
    try {
      ServerBootstrap b = new ServerBootstrap(); // (2)
      b.group(group)
          .channel(NioServerSocketChannel.class) // (3)
          .localAddress(new InetSocketAddress(port))
          .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast(serverHandler);
            }
          })
          .option(ChannelOption.SO_BACKLOG, 128)          // (5)
          .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

      // Bind and start to accept incoming connections.
      ChannelFuture f = b.bind().sync(); // (7)

      // Wait until the server socket is closed.
      // In this example, this does not happen, but you can do that to gracefully
      // shut down your server.
      f.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
    }
  }

  public static void main(String[] args) throws Exception {
    int port = 8009;
    if (args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    new EchoServer(port).start();
  }
}
