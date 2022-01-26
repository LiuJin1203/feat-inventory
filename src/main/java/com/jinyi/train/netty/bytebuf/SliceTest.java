package com.jinyi.train.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.IllegalReferenceCountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.jinyi.train.netty.bytebuf.ByteBufPrint.print;
import static com.jinyi.train.netty.bytebuf.ByteBufPrint.printByteBufStr;

/**
 * 切片浅层复制
 */
public class SliceTest {


    @Test
    public void testSlice() {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        print("动作：分配 ByteBuf(9, 100)", buffer);
        buffer.writeBytes(new byte[]{98, 82, 93, 74});
        print("动作：写入4个字节 (1,2,3,4)", buffer);
        //无参方法返回可读部分切片
        ByteBuf slice = buffer.slice();
        printByteBufStr( slice);
        ByteBuf slice2 = buffer.slice(0,2);
        printByteBufStr( slice2);

        buffer.release();
        //此处应该抛异常 IllegalReferenceCountException: refCnt: 0
        //因为浅层复制公用底层数据，释放后，引用计数器为0，不可以继续读取
       Assertions.assertThrows(IllegalReferenceCountException.class,()-> printByteBufStr(slice2),"浅层复制公用底层数据,计数器清零异常");
    }

}