import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class nettyserver {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossgroup = new NioEventLoopGroup();
        NioEventLoopGroup workgroup = new NioEventLoopGroup();

        ServerBootstrap Bootstrap = new ServerBootstrap();


        Bootstrap.group(bossgroup, workgroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast((new handler()));
                    }
                });
        System.out.println("服务器已经准备好");

        ChannelFuture cf=Bootstrap.bind(6668);
        Thread.sleep(100);
        System.out.println(cf.isSuccess());
        cf.addListener(future -> {
            if(future.isSuccess())
                System.out.println("绑定成功");
            else
                System.out.println("绑定失败");

        });
        cf.channel().closeFuture().sync();



    }
}
