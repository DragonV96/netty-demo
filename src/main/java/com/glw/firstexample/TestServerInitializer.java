package com.glw.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author : glw
 * @date : 2019/11/19
 * @time : 10:21
 * @Description : 初始化类
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // 执行顺序与添加顺序一致
        pipeline.addLast("httpServerCodec", new HttpServerCodec())  // 添加拦截器处理来自客户端的消息（此处不能单例）
                .addLast("testHttpServerHandler", new TestHttpServerHandler());  // 添加拦截器用于处理即将发往客户端的消息（此处不能单例）
    }
}
