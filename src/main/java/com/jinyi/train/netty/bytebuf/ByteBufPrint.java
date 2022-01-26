package com.jinyi.train.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;


public class ByteBufPrint {
    private static final Logger log = LoggerFactory.getLogger(ByteBufPrint.class);
    final static Charset UTF_8 = Charset.forName("UTF-8");

    public static void print(String action, ByteBuf b) {
        log.info("after ===========" + action + "============");
        log.info("1.0 isReadable(): " + b.isReadable());
        log.info("1.1 readerIndex(): " + b.readerIndex());
        log.info("1.2 readableBytes(): " + b.readableBytes());
        log.info("2.0 isWritable(): " + b.isWritable());
        log.info("2.1 writerIndex(): " + b.writerIndex());
        log.info("2.2 writableBytes(): " + b.writableBytes());
        log.info("3.0 capacity(): " + b.capacity());
        log.info("3.1 maxCapacity(): " + b.maxCapacity());
        log.info("3.2 maxWritableBytes(): " + b.maxWritableBytes());
    }

    public static void printByteBufStr(ByteBuf buf){
        log.info(" ===========" + "printByteBufStr" + "============");
        if (!buf.hasArray()) {
            int length = buf.readableBytes();
            byte[] array = new byte[length];
            //读取数据到堆内存
            buf.getBytes(buf.readerIndex(), array);
            log.info(new String(array, UTF_8));
        }
    }
}
