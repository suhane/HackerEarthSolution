package exception;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {

    @Test
    public void test(){
        String str="hello";
        String str1="hello";

        Assert.assertTrue(str==str1);
        Assert.assertTrue(str.equals(str1));
        Assert.assertTrue(str.hashCode()==str1.hashCode());
    }
}
