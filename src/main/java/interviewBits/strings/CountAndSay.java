package interviewBits.strings;

/**
 * Created by labuser on 7/19/17.
 */
public class CountAndSay {

    public static String countAndSay(int a) {
        String output="";
        int sequence=1;
        String start="1";
        if(a==1)
            return start;


        while(sequence<a){
             int length=start.length();
             String temp="";
             for(int i=0;i<length;i++){
                 int count=1;
                 while(i<length-1 && start.charAt(i)==start.charAt(i+1)) {
                     i++;
                     count++;
                 }
                 temp+=count+""+start.charAt(i);
             }

            start=temp;
            sequence++;
        }

        return start;

    }

    public static void main(String args[]){
        countAndSay(6);
    }
}
