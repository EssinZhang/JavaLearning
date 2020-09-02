package com.example.netty01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * description: 自定义服务端处理器 <br>
 *     需求：用户提交一个请求以后 在浏览器上就能看到hello netty
 * date: 2020/9/2 09:49 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SomeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当channel中有来自于客户端的数据时就会触发该方法的执行
     * @param ctx 上下文对象
     * @param msg 来自客户端的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
//        System.out.println("msg.getclass :" + msg.getClass());
//        System.out.println("客户端地址：" + ctx.channel().remoteAddress());

        if (msg instanceof HttpRequest){
            HttpRequest httpRequest = (HttpRequest) msg;
            System.out.println("请求方式：" + httpRequest.getMethod().name());
            System.out.println("请求的URI：" + httpRequest.uri());

            // 构造response的响应体
            ByteBuf body = Unpooled.copiedBuffer("hello netty", CharsetUtil.UTF_8);
            // 生成相应对象
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, body);
            // 获取到response的头部进行初始化
            HttpHeaders headers = response.headers();
            headers.set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            headers.set(HttpHeaderNames.CONTENT_LENGTH,body.readableBytes());

            // 将相应对象写入到channel
            //ctx.write(response);
            //ctx.flush();
            //ctx.writeAndFlush(response);
            // 添加监听器，响应体发送完毕后直接将channel关闭
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

        }

    }

    /**
     * 当channel中的数据在处理过程中出现异常时会触发该方法执行
     * @param ctx 上下文
     * @param cause 发生的异常对象
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        //关闭channel
        ctx.close();

    }
}
