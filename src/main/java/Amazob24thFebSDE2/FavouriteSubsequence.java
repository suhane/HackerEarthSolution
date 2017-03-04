package Amazob24thFebSDE2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by suhane on 10/2/16.
 */
public class FavouriteSubsequence {

    class InputReader{
        BufferedReader br;
        StringTokenizer token;

        public InputReader(InputStream stream){
            br=new BufferedReader(new InputStreamReader(stream));
            token=null;
        }

        public String next(){
            while(token==null || !token.hasMoreTokens()){
                try{
                    token= new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return token.nextToken();
        }

        public int nextInt(){
            return  Integer.parseInt(next());
        }
    }

    public static void main(String args[]){
        InputReader in= new FavouriteSubsequence().new InputReader(System.in);
        PrintWriter out =new PrintWriter(System.out);
        String str=in.next();
        solve(in,out,str);
        out.close();
        System.exit(0);
    }

    private static void solve(InputReader in, PrintWriter out, String str){

        ArrayList<Integer> list_a=new ArrayList<Integer>();
        ArrayList<Integer> list_b=new ArrayList<Integer>();
        ArrayList<Integer> list_c=new ArrayList<Integer>();
        char[] strArray=str.toCharArray();
        int index=1;
        for(char ch: strArray)

            switch (ch) {
                case 'a':
                    list_a.add(index++);
                    break;
                case 'b':
                    list_b.add(index++);
                    break;
                case 'c':
                    list_c.add(index++);
                    break;

            }

        int size_a=list_a.size();
        int size_b=list_b.size();
        int size_c=list_c.size();
        int sum=0;

        for(int i=0;i<size_a;i++){
            double multiplier_a=Math.pow(2,i);
            int index_a=list_a.get(i);
            int index_b=nextHighestIndex(strArray,'b',index_a);
            if(index_b==-1)
                break;

            for(int j=list_b.indexOf(index_b),j_pow=0;j<size_b;j++,j_pow++){
                double multiplier_b= Math.pow(2,j_pow);
                int index_c=nextHighestIndex(strArray,'c',list_b.get(j));
                if(index_c!=-1) {
                    int candidateElems = size_c - list_c.indexOf(index_c);
                    double multiplier_c = calculateBinomialSum(candidateElems);
                    sum += multiplier_a * multiplier_b * multiplier_c;
                }
                else
                    break;
            }
        }
        System.out.println(sum);

        }

    private static double calculateBinomialSum(int exponent) {
        double sum=0;
        for(int i=0;i<exponent;i++){
            sum+=Math.pow(2,i);
        }
        return  sum;
    }

    private static int nextHighestIndex(char[] str, char ch, int index){

        while(index<str.length && str[index]!= ch){
            index++;
        }
        if(index>=str.length)
            return -1;
        else
            return index+1;
    }


}
