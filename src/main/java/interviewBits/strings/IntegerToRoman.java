package interviewBits.strings;

/**
 * Created by labuser on 7/22/17.
 */
public class IntegerToRoman {
    public static String intToRoman(int a) {
        String[] literals={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] numbers={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=1;
        int n=numbers.length;
        String output="";

        if(a>=numbers[0]){
            int times=a/numbers[0];
            a = a - times*numbers[0];
            while(times-->0)
                output += literals[0];
        }
        while(a>0&& i<n) {
            if (a >= numbers[i] && a < numbers[i-1])
                {
                    int times = a / numbers[i];
                    a = a - times * numbers[i];
                    while (times-- > 0)
                        output += literals[i];
                }
                else{
                    i++;
                }
        }
        return output;

    }


    private static int equivalentInt(char c){

        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'M':
                return 1000;
            case 'C':
                return 100;
            case 'D':
                return 500;

        }
        return 0;
    }

    private static char subtractive(char c){
        if(c=='M' || c=='D')
            return 'C';
        if(c=='C' || c=='L')
            return 'X';
        return 'I';
    }

    private static char equivalentChar(int n){

        switch (n){
            case 1:
                return 'I';
            case 5:
                return 'V';
            case 10:
                return 'X';
            case 50:
                return 'L';
            case 1000:
                return 'M';
            case 100:
                return 'C';
            case 500:
                return 'D';

        }
        return '.';
    }

    public static void main(String args[]){

        System.out.print(intToRoman(1001));
    }
}
