package com.jinyi.train.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @author liujin
 * @date 2022/1/25
 * @since JDK8
 */
public class BufferTypeOps {
    private static final Logger log = LoggerFactory.getLogger(BufferTypeOps.class);
    final static Charset UTF_8 = Charset.forName("UTF-8");

    public static void main(String[] args) {
        testHeapBuffer();
        testDirectBuffer();
    }


    //堆缓冲区
    public static void testHeapBuffer() {
        //取得堆内存
        //取得堆内存--netty4默认直接buffer，而非堆buffer
        //ByteBuf heapBuf = ByteBufAllocator.DEFAULT.buffer();
        ByteBuf heapBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        heapBuf.writeBytes("字节容器缓冲区类型-堆内存".getBytes(UTF_8));
        if (heapBuf.hasArray()) {
            //取得内部数组
            byte[] array = heapBuf.array();
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            int length = heapBuf.readableBytes();
            log.info(new String(array, offset, length, UTF_8));
        }
        heapBuf.release();

    }

    //直接缓冲区
    public static void testDirectBuffer() {
        ByteBuf directBuf = ByteBufAllocator.DEFAULT.directBuffer();
        directBuf.writeBytes("字节容器缓冲区类型-直接缓冲区".getBytes(UTF_8));
        if (!directBuf.hasArray()) {
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            //读取数据到堆内存
            directBuf.getBytes(directBuf.readerIndex(), array);
            log.info(new String(array, UTF_8));
        }
        directBuf.release();
    }
}
