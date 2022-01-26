package edu.jinyi.study.example.singleexample;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liujin
 * @since JDK8
 */
public class Demo {
    private static int flag = 1;
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        testFor();

        System.out.println("after testFor function");
        System.out.println("CAPACITY："+Integer.toBinaryString(CAPACITY)+"_"+CAPACITY);
        System.out.println("RUNNING ："+Integer.toBinaryString(RUNNING));
        System.out.println("—— -1   ："+Integer.toBinaryString(-2));
    }

    private static void testFor() {
        for (;;){
            System.out.println("ready go into from outFor");
            for (;;){
                System.out.println("enter for");
                if(flag==1){
                    System.out.println("ready return");
                    return;

                }
                System.out.println("after return");
            }
//            System.out.println("ready go out from outFor");
//            return;
        }
    }
}
