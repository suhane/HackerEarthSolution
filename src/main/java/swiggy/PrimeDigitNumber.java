package swiggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrimeDigitNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String N = br.readLine();

        String out_ = primeDigitNumber(N);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static String primeDigitNumber(String N){

       int l=N.length();
       StringBuilder sb= new StringBuilder();
       boolean libertyFlag=false;

        String last="";
        int curr_length=0;
       for(int i=0;i<l;i++){
           int c=Integer.parseInt(N.substring(i,i+1));
           if(i==0){
               if(c==1) {
                   last="7";
                   sb.append(last);
                   i++;
                   libertyFlag=true;
                   curr_length++;
               }
               else{
                   last=getLargestPrime(c);
                   if(Integer.parseInt(last)<c)
                       libertyFlag=true;
                   sb.append(last);
                   curr_length++;
               }
           }
           else {
               if(libertyFlag){
                   last="7";
                   sb.append(last);
                   curr_length++;
               }

               else {
                   if(c==0 || c==1){
                        last=getLargestPrime(Integer.parseInt(last)-1);
                        sb.deleteCharAt(curr_length-1);
                        sb.append(last);
                        if(!last.equals("7"))
                            sb.append("7");
                        libertyFlag=true;


                   }
                   else {
                       last = getLargestPrime(c);
                       sb.append(last);
                       curr_length++;
                   }

               }
           }

       }
       return sb.toString();
        // Write your code here

    }

    private static String getLargestPrime(int c) {
        if(c==2)
            return "2";
        if(c<=4 && c>2)
            return "3";
        if(c<=6 && c>4)
            return "5";
        return "7";
        }


}

