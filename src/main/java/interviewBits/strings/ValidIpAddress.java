package interviewBits.strings;

import java.util.ArrayList;

/**
 * Created by labuser on 7/22/17.
 */
public class ValidIpAddress {
    public ArrayList<String> restoreIpAddresses(String a) {
        int len=a.length();
        ArrayList<String> output= new ArrayList<String>();
        if(len>12 && len<4)
            return output;
        return null;

    }
}
