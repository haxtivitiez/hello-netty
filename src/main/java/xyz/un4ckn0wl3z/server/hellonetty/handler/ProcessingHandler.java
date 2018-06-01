package xyz.un4ckn0wl3z.server.hellonetty.handler;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import xyz.un4ckn0wl3z.hellonetty.model.RequestData;
import xyz.un4ckn0wl3z.hellonetty.model.ResponseData;

public class ProcessingHandler extends ChannelInboundHandlerAdapter {
	
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Handler added");
	
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Handler removed");
	
	}
	 
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) 
      throws Exception {
  
        RequestData requestData = (RequestData) msg;
        ResponseData responseData = new ResponseData();
        responseData.setIntValue(requestData.getIntValue() * 2);
        ChannelFuture future = ctx.writeAndFlush(responseData);
        future.addListener(ChannelFutureListener.CLOSE);
        System.out.println("[SERVER] : "+requestData);
    }
}