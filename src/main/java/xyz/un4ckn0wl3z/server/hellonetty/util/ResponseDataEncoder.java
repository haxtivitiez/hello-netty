package xyz.un4ckn0wl3z.server.hellonetty.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import xyz.un4ckn0wl3z.hellonetty.model.ResponseData;

public class ResponseDataEncoder 
extends MessageToByteEncoder<ResponseData> {

  @Override
  protected void encode(ChannelHandlerContext ctx, 
    ResponseData msg, ByteBuf out) throws Exception {
      out.writeInt(msg.getIntValue());
  }
}