package interviewBits.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {


    public  static boolean wordBreak(String a, ArrayList<String> b) {

        int size=a.length();
        if(size==0)
            return true;
        boolean[] wb=new boolean[size+1];
        wb[0]=true;
        for(int i=0;i<size;i++){

            if(!wb[i])
                continue;

            for(String str: b){
                  int len=str.length();
                int end=len+i;
                if(end>size)
                    continue;
                if(a.substring(i,end).equals(str)){
                    wb[end]=true;
                    if(end==size)
                        return true;
                }

            }
        }
        return false;


    }

    public  static boolean wordBreakTLE(String a, ArrayList<String> b) {

        int size=a.length();
        if(size==0)
            return true;
        boolean[] wb=new boolean[size+1];

        for(int i=1;i<=size;i++){

            if(wb[i]==false && isValid(a.substring(0,i),b))
                wb[i]=true;

            if(wb[i]==true){
                if (i == size)
                    return true;
                for (int j = i+1; j <= size; j++) {
                    if(wb[j]==false && isValid(a.substring(i,j),b))
                        wb[j]=true;

                    if (j == size && wb[j] == true)
                        return true;
                }

            }


        }
        return false;


    }

    private static boolean isWordBreak(String a, ArrayList<String> b) {

        int size=a.length();
        if(size==0)
            return true;

        for(int i=1;i<=size;i++){
            if(isValid(a.substring(0,i),b) && isWordBreak(a.substring(i,size),b))
                return true;
        }
        return false;
    }

    private static boolean isValid(String substring, ArrayList<String> b) {

        for(String str:b){
            if(str.equals(substring))
                return true;

        }
        return false;
    }



    public static void main(String args[]){
        ArrayList<String> list= new ArrayList<String>(Arrays.asList("cat", "and", "sand"));
        System.out.println(wordBreak("sandandcat",list));
    }
}
