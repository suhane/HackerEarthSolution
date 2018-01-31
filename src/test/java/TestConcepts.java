import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by suhane on 1/18/17.
 */
public class TestConcepts {

    @Test
    public void absoluteofMostNegativeValue(){
        final int mostNegative=Integer.MIN_VALUE;
        final int negated= Math.abs(mostNegative);
        assertTrue("No Positive equivalent of Integer.MinValue", negated<0);
    }

    @Test (expected = NullPointerException.class)
    public void expectNullPointerExpTobeThrown(){
        final String s=null;
        s.length();
    }

    @Test
    public void objectMemAssignment(){
        ArrayList<String> l1=new ArrayList<String>();
        l1.add("one");
        assertTrue(l1.size()==1);
        ArrayList l2=l1;
        l2.add("two");
        assertTrue(l1.size()==2);
    }
}
