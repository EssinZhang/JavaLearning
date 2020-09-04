package com.example.netty02;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * description: AHandler <br>
 * date: 2020/9/4 16:37 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class AServer extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        // 将来自于客户端的数据显示在服务端控制台
        System.out.println(ctx.channel().remoteAddress()+","+msg );
        // 向客户端发送数据
        ctx.channel().writeAndFlush("from server : "+ UUID.randomUUID());
        TimeUnit.MICROSECONDS.sleep(500);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
