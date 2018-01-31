package interviewBits.strings;

import java.util.ArrayList;

/**
 * Created by labuser on 7/22/17.
 */
public class ReverseWords {
    public static String reverseWords(String a) {

        String test=a.trim();
        int n=test.length();
        String input="";
        for(int i=0;i<n;i++){
            while(i<n && test.charAt(i)==' ' && test.charAt(i+1)==' '){
                i++;
            }
            input+=test.charAt(i);
        }

        String[] strs=input.split(" ");
        String out="";
        int len=strs.length;
        for(int i=len-1;i>0;i--){
            out+=strs[i]+" ";
        }
        out+=strs[0];
        return out;

    }

    private  static boolean isAlphabet(char c){
        return ((c>=65 && c<=90) || (c>=97 && c<=122));
    }

    private  static String reverse(String a,int i,int j){
        char[] arr=a.toCharArray();
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }


    public static void main(String args[]){

        System.out.print(reverseWords(""));
    }
}
