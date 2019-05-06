package com.guo.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * echoServer类
 *
 * @author dengguoqing
 * @date 2019/5/4
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception{
        if (args.length != 1) {
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + "<port>");
            return;
        }

        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }
    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group).channel(NioServerSocketChannel.class).
                    localAddress(new InetSocketAddress((port))).childHandler(
                    new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(
                                SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(serverHandler);
                        }
                    });
            ChannelFuture future = bootstrap.bind().sync();
            future.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
