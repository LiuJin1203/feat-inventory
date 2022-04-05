package fit.jinyi.tool.test;

import fit.jinyi.tool.security.MessageDigestUtil;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 */
public class MessageDigestTest {
    @Test
    public void secret_md5(){
        String source = "123456happy#&$";
        String m = MessageDigestUtil.getInstance().MD5(source);
        Assert.assertEquals("B5C6877F6783AC737ADA09C79B0F536C",m);
        Assert.assertEquals("b5c6877f6783ac737ada09c79b0f536c",m.toLowerCase());
    }
}
