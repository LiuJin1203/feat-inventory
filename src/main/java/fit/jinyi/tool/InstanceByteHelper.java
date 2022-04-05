package fit.jinyi.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liujin
 * @date 2022/1/6
 * @since JDK8
 */
public class InstanceByteHelper {
    private InstanceByteHelper() {
    }

    private static class SingleHolder {
        public static final InstanceByteHelper instance = new InstanceByteHelper();
    }

    public static InstanceByteHelper getInstance() {
        return SingleHolder.instance;
    }


    public byte[] instanceToBytes(Object instance){
        ByteArrayOutputStream byt=new ByteArrayOutputStream();
        ObjectOutputStream obj= null;
        try {
            obj = new ObjectOutputStream(byt);
            obj.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes=byt.toByteArray();
        return bytes;
    }

    public <T> T bytesToObject(byte[] bytes,Class<T> clz){
        ByteArrayInputStream byteInt=new ByteArrayInputStream(bytes);
        ObjectInputStream objInt= null;
        try {
            objInt = new ObjectInputStream(byteInt);
            T t =(T)objInt.readObject();
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void bytesPrint(byte[] bytes){
        char[] chars = new char[bytes.length];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            list.add(toHexString(bytes[i]));
            chars[i] = (char) bytes[i];
        }
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(list.toArray()));
    }

    private String toHexString(byte b){
        String s = Integer.toHexString(b & 0xFF);
        if (s.length() == 1){
            return "0" + s;
        }else{
            return s;
        }
    }

}
