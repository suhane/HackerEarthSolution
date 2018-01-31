package expedia;

import org.junit.Test;

import java.util.*;
import java.util.LinkedList;

public class PrintAnagrams {

    public void printAnagrams(String str){

        int n=str.length();
        if(n==0)
            return;
        Queue<String> q= new LinkedList<>();
        q.offer(str.substring(0,1));
        while (q.peek().length()!=n){
            String aux=q.poll();
            int len=aux.length();
            for(int pos=0;pos<=len;pos++){
                q.offer(aux.substring(0,pos)+str.substring(len,len+1)+aux.substring(pos,len));
            }


        }

        System.out.println(q.size());

        while (!q.isEmpty()){
            System.out.println(q.poll());
        }

    }

    @Test
    public void test(){
        printAnagrams("abc");
    }
}
