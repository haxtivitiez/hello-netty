package xyz.un4ckn0wl3z.server.hellonetty.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.util.List;

import xyz.un4ckn0wl3z.hellonetty.model.RequestData;

public class RequestDecoder extends ReplayingDecoder<RequestData> {

	private final Charset charset = Charset.forName("UTF-8");

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {

		RequestData data = new RequestData();
		data.setIntValue(in.readInt());
		int strLen = in.readInt();
		data.setStringValue(in.readCharSequence(strLen, charset).toString());
		out.add(data);
	}
}