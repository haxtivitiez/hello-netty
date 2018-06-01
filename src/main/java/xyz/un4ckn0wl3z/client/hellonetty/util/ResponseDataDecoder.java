package xyz.un4ckn0wl3z.client.hellonetty.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

import xyz.un4ckn0wl3z.hellonetty.model.ResponseData;

public class ResponseDataDecoder 
extends ReplayingDecoder<ResponseData> {

  @Override
  protected void decode(ChannelHandlerContext ctx, 
    ByteBuf in, List<Object> out) throws Exception {

      ResponseData data = new ResponseData();
      data.setIntValue(in.readInt());
      out.add(data);
  }
}