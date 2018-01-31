package interviewBits.dynamicProgramming;

public class WayToDecode {

   static public int numDecodings(String a) {

        char[] arr=a.toCharArray();
        int n=arr.length;
        int[] count= new int[n+1];
        count[0]=1;
        count[1]=1;
        for(int i=2;i<=n;i++){
            if(arr[i-1]!='0'){
                count[i]=count[i-1];
            }
            if(arr[i-2]=='1' || (arr[i-2]=='2' && arr[i-2]<55) ){
                count[i]+=count[i-2];
            }
        }
        return count[n];

    }


    static int countDecoding(char[] digits, int n)
    {
        // base cases
        if (n == 0 || n == 1)
            return 1;

        int count = 0;  // Initialize count

        // If the last digit is not 0, then last digit must add to
        // the number of words
        if (digits[n-1] > '0')
            count =  countDecoding(digits,n-1);

        // If the last two digits form a number smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n-2] == '1' || (digits[n-2] == '2' && digits[n-1] < '7') )
            count +=  countDecoding(digits, n-2);

        return count;
    }

    public static void main(String args[])
    {

        System.out.println(numDecodings("1221"));
    }
}
