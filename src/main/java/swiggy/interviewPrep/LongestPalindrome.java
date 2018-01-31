package swiggy.interviewPrep;

import org.junit.Test;

public class LongestPalindrome {

    private boolean checkPalindrome(String str, int start, int end){

        while (start<end){
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public int findLongestPalindrome(String str){
        int maxLength=0;
        int l=str.length();
        for(int i=0;i<l;i++){
            for (int j=i;j<l;j++){
                if(checkPalindrome(str,i,j))
                    maxLength=Math.max(maxLength,j-i+1);
            }
        }
        return maxLength;
    }

    public int lpsubstring(String str,int i,int j,int len){

        if (i == j)
            return len+1;
        if(i>j)
            return len;

        if (str.charAt(i) == str.charAt(j))
            return lpsubstring (str, i+1, j-1,len+2);
        return Math.max( lpsubstring(str, i, j-1,0), lpsubstring(str, i+1, j,0) );
    }

    public String lpsubstring(String str){
        int maxLength=1;
        int n=str.length();
        boolean[][] dp=new boolean[n][n];
        for (int i = 0; i < n; ++i)
            dp[i][i] = true;
        int start=0;
        for(int i=0;i<n-1;++i){
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; ++k) {

            for(int i=0;i<n - k+1;i++){
                int j = i + k - 1;

                if(dp[i+1][j-1] && str.charAt(i)==str.charAt(j)){

                    dp[i][j]=true;
                    if(k>maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }

            }

        }
        return str.substring(start,maxLength+start);



    }

    public String lpsubstringNonDP(String str){
        int maxLength = 1;
        int start = 0;
        int len = str.length();
        int low, high;

        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;

            while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){

                if(high-low+1>maxLength){
                    maxLength=high-low+1;
                    start=low;
                }
                low--;
                high++;

            }

            // Find the longest odd length palindrome with
            // center points i.

            low=i-1;
            high=i+1;

            while (low>=0 && high<len && str.charAt(low)==str.charAt(high)){

                if(high-low+1>maxLength){
                    maxLength=high-low+1;
                    start=low;
                }
                low--;
                high++;
            }

        }
        return str.substring(start,maxLength+start);

    }

    @Test
    public void testBruteForce(){

        String str="dgckjdgjkdgsjvgdsjkvgkldsgvkldsgvlksgdklvgdksgjdsgjkvgdsjklvglkdsgvkldsgljvgsldjgvlkdsgvklgdsklghvkdsgvklsdgkvgsdklvgklsdgvklsdgvklsdgvklgsdklvgsklgvklsgvklgsklgvklgskldgvlisehgvilesgvikesgvklegssgelkvgsekivgselivghesilvgdlksglkvglksglkvgslkvglksgvlkdsglkvgdslkvgdslkvgdslkgvlkdsgvkgdslkvgsdkvhglksdglkvgsdklvgjdlsgvjlgsdlkvgsdklgvlkjsdgvkjgsdjgskdgvlkdgsklvgsdlkvgsdlkgvkjsdgvjsgdkjgdjkcgd";
        System.out.println(findLongestPalindrome(str));
    }

    @Test
    public void testRecursive(){

        String str="dgckjdgjkdgsjvgdsjkvgkldsgvkldsgvlksgdklvgdksgjdsgjkvgdsjklvglkdsgvkldsgljvgsldjgvlkdsgvklgdsklghvkdsgvklsdgkvgsdklvgklsdgvklsdgvklsdgvklgsdklvgsklgvklsgvklgsklgvklgskldgvlisehgvilesgvikesgvklegssgelkvgsekivgselivghesilvgdlksglkvglksglkvgslkvglksgvlkdsglkvgdslkvgdslkvgdslkgvlkdsgvkgdslkvgsdkvhglksdglkvgsdklvgjdlsgvjlgsdlkvgsdklgvlkjsdgvkjgsdjgskdgvlkdgsklvgsdlkvgsdlkgvkjsdgvjsgdkjgdjkcgd";
        System.out.println(lpsubstring(str,0,str.length()-1,0));
    }

    @Test
    public void testDP(){

        String str="dgckjdgjkdgsjvgdsjkvgkldsgvkldsgvlksgdklvgdksgjdsgjkvgdsjklvglkdsgvkldsgljvgsldjgvlkdsgvklgdsklghvkdsgvklsdgkvgsdklvgklsdgvklsdgvklsdgvklgsdklvgsklgvklsgvklgsklgvklgskldgvlisehgvilesgvikesgvklegssgelkvgsekivgselivghesilvgdlksglkvglksglkvgslkvglksgvlkdsglkvgdslkvgdslkvgdslkgvlkdsgvkgdslkvgsdkvhglksdglkvgsdklvgjdlsgvjlgsdlkvgsdklgvlkjsdgvkjgsdjgskdgvlkdgsklvgsdlkvgsdlkgvkjsdgvjsgdkjgdjkcgd";
        System.out.println(lpsubstring("dgckjdgjkdgsjvgdsjkvgkldsgvkldsgvlksgdklvgdksgjdsgjkvgdsjklvglkdsgvkldsgljvgsldjgvlkdsgvklgdsklghvkdsgvklsdgkvgsdklvgklsdgvklsdgvklsdgvklgsdklvgsklgvklsgvklgsklgvklgskldgvlisehgvilesgvikesgvklegssgelkvgsekivgselivghesilvgdlksglkvglksglkvgslkvglksgvlkdsglkvgdslkvgdslkvgdslkgvlkdsgvkgdslkvgsdkvhglksdglkvgsdklvgjdlsgvjlgsdlkvgsdklgvlkjsdgvkjgsdjgskdgvlkdgsklvgsdlkvgsdlkgvkjsdgvjsgdkjgdjkcgd").length());
    }

    @Test
    public void testNonDP(){

        String str="dgckjdgjkdgsjvgdsjkvgkldsgvkldsgvlksgdklvgdksgjdsgjkvgdsjklvglkdsgvkldsgljvgsldjgvlkdsgvklgdsklghvkdsgvklsdgkvgsdklvgklsdgvklsdgvklsdgvklgsdklvgsklgvklsgvklgsklgvklgskldgvlisehgvilesgvikesgvklegssgelkvgsekivgselivghesilvgdlksglkvglksglkvgslkvglksgvlkdsglkvgdslkvgdslkvgdslkgvlkdsgvkgdslkvgsdkvhglksdglkvgsdklvgjdlsgvjlgsdlkvgsdklgvlkjsdgvkjgsdjgskdgvlkdgsklvgsdlkvgsdlkgvkjsdgvjsgdkjgdjkcgd";
        System.out.println(lpsubstringNonDP("dgckjdgjkdgsjvgdsjkvgkldsgvkldsgvlksgdklvgdksgjdsgjkvgdsjklvglkdsgvkldsgljvgsldjgvlkdsgvklgdsklghvkdsgvklsdgkvgsdklvgklsdgvklsdgvklsdgvklgsdklvgsklgvklsgvklgsklgvklgskldgvlisehgvilesgvikesgvklegssgelkvgsekivgselivghesilvgdlksglkvglksglkvgslkvglksgvlkdsglkvgdslkvgdslkvgdslkgvlkdsgvkgdslkvgsdkvhglksdglkvgsdklvgjdlsgvjlgsdlkvgsdklgvlkjsdgvkjgsdjgskdgvlkdgsklvgsdlkvgsdlkgvkjsdgvjsgdkjgdjkcgd").length());
    }


}
