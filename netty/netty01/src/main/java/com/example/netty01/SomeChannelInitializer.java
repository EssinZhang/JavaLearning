package com.example.netty01;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * description: 管道初始化器 <br>
 * date: 2020/8/31 09:47 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SomeChannelInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * channel初始创建完毕后就会触发这个方法，初始化channel
     * @param socketChannel
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //从channel中获取pipeline
        ChannelPipeline pipeline = socketChannel.pipeline();
        /**
         * 将HttpServerCodec处理器放到pipeline最后
         * HttpServerCodec是 HttpRequestDecoder 和 HttpResponseEncoder的复合体
         * HttpRequestDecoder:http  请求解码器，将channel中的byteBuffer数据解码为httpRequest对象
         * HttpResponseEncoder： http 相应编码器，将HTTPResponse对象编码为 需要在channel中回传的byteBuffer
         */
        pipeline.addLast(new HttpServerCodec());
        //将自定义的处理器放入到pipeline·的最后
        pipeline.addLast(new SomeServerHandler());


    }
}
