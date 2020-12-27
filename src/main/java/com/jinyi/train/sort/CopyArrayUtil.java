package com.jinyi.train.sort;

/**
 * @author liujin
 * @date 2020/12/27
 * @since JDK8
 */
public class CopyArrayUtil {
   public static Comparable[] copy(Comparable[] arr){
        if(arr==null||arr.length<2){
            return new Comparable[1];
        }
        int N = arr.length;
        Comparable[] dest = new Comparable[N];
        System.arraycopy(arr,0,dest,0,N);
        return dest;
    }
}
