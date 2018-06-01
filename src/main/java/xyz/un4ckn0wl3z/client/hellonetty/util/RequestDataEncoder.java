package xyz.un4ckn0wl3z.client.hellonetty.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

import xyz.un4ckn0wl3z.hellonetty.model.RequestData;

public class RequestDataEncoder 
extends MessageToByteEncoder<RequestData> {

  private final Charset charset = Charset.forName("UTF-8");

  @Override
  protected void encode(ChannelHandlerContext ctx, 
    RequestData msg, ByteBuf out) throws Exception {

      out.writeInt(msg.getIntValue());
      out.writeInt(msg.getStringValue().length());
      out.writeCharSequence(msg.getStringValue(), charset);
  }
}
