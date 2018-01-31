package interviewBits.arrayMath;

import java.util.ArrayList;

/**
 * Created by labuser on 7/15/17.
 */
public class FizzBuzz {

    public ArrayList<String> fizzBuzz(int A) {

        ArrayList<String> output=new ArrayList<String>();

        for(int i=1; i<=A;i++){
            if(i%5!=0 && i%2==0)
                output.add("Fizz");
            else if(i%5==0 && i%2!=0)
                output.add("Buzz");
            else if(i%5==0 && i%2==0)
                    output.add("FizzBuzz");
            else
                output.add(i+"");


        }
        return output;
    }

}
