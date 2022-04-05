package fit.jinyi.tool.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 信息摘要工具类
 */
public class MessageDigestUtil {
    private static final Logger log = LoggerFactory.getLogger(MessageDigestUtil.class);

    private MessageDigestUtil() {
    }
    private static class SingleHolder{
        private static final MessageDigestUtil instance = new MessageDigestUtil();
    }
    public static MessageDigestUtil getInstance(){
        return MessageDigestUtil.SingleHolder.instance;
    }
    
    public String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);//高4位
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);//低4位
        }
        return ret.toString();
    }

    public String encodeURIComponent(String s) {
        String result = null;

        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\!", "%21")
                    .replaceAll("\\'", "%27")
                    .replaceAll("\\(", "%28")
                    .replaceAll("\\)", "%29")
                    .replaceAll("\\~", "%7E");
        }
        // This exception should never occur.
        catch (UnsupportedEncodingException e) {
            result = s;
        }

        return result;
    }

    public String base64Base(String target) {
        // 使用基本编码
        String base64encodedString = null;
        try {
            base64encodedString = Base64.getEncoder().encodeToString(target.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
        return base64encodedString;
    }

    public String base64BaseUrl(String target) {
        // 使用基本编码
        String base64encodedString = null;
        try {
            base64encodedString = Base64.getUrlEncoder().encodeToString(target.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
        return base64encodedString;
    }

    public String base64BaseMime(String target) {
        // 使用基本编码
        String base64encodedString = null;
        try {
            base64encodedString = Base64.getMimeEncoder().encodeToString(target.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
        return base64encodedString;
    }

}
