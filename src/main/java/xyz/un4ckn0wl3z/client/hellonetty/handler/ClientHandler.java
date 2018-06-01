package xyz.un4ckn0wl3z.client.hellonetty.handler;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import xyz.un4ckn0wl3z.hellonetty.model.RequestData;
import xyz.un4ckn0wl3z.hellonetty.model.ResponseData;

public class ClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		RequestData msg = new RequestData();
		msg.setIntValue(123);
		msg.setStringValue("all work and no play makes jack a dull boy");
		ChannelFuture future = ctx.writeAndFlush(msg);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println("[CLIENT: ]"+(ResponseData) msg);
		ctx.close();
	}
}
