package com.example.netty01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * description: 服务器启动类 <br>
 * date: 2020/8/28 09:38 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SomeServer {
    public static void main(String[] args) {
        //处理客户端连接请求
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        //对用户请求进行处理
        EventLoopGroup childGroup = new NioEventLoopGroup();


        try {
            //用于启动serverChannel
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            /**
             * 第一行指定EventLoopGroup
             * 第二行指定使用的NIO通信
             * 第三行执行childGroup中的eventloop所绑定的线程 的处理器
             */
            serverBootstrap.group(parentGroup,childGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(null);

            /**
             * 指定当前服务器所监听的端口号
             * bind（）方法的执行时异步的
             * sync（）方法会使bind（）操作和后续的代码的执行由异步变为同步
             */
            ChannelFuture future = serverBootstrap.bind(8888).sync();
            System.out.println("服务器启动成功，监听的端口号为8888");
            /**
             * 关闭channel
             * closeFuture（）的执行时异步的
             * 当channel调用了close（）方法并关闭成功后才会触发closeFuture（）方法的执行
             */
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅关闭group
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
