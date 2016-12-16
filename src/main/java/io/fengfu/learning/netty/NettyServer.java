package io.fengfu.learning.netty;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * Created by fengfu on 14-3-21.
 */
public class NettyServer {
    private int port;

    public NettyServer(int port){
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
    }

    public static void main(String[] args) throws Exception{
        new NettyServer(7890).run();
    }
}