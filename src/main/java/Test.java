public class Test {

    public static void main(String args[]){
        //System.out.println(findprime(6));

        System.out.println(reverseWordbyWord("My namer is Starth"));

    }

    public static boolean checkPrime(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0)
                return false;

        }
        return true;

    }

    public static int findprime(int n){
        int num=2;
        while(n>0){
            boolean res=checkPrime(num);
            if(res) {
                n--;
                num++;
            }
            else num++;

        }
        return num-1;
    }

    public static String reverseWordbyWord(String str){
        String arr[] = str.split(" ");
        String result="";
        for(int i=arr.length-1;i>=0;i--){
            result+=arr[i];
            if(i!=0){
                result+=" ";
            }
        }
        return result;



    }


}
