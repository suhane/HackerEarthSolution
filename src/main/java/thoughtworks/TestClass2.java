package thoughtworks;


/*
Choose K Numbers
You are given an array
A
r
r
i
Arri of size
N
N. You have to find the maximum value of
K
K such that after choosing
K
K numbers from the array the
D
i
f
f
V
a
l
u
e
DiffValue of chosen numbers is less than or equal to
S
S.

D
i
f
f
V
a
l
u
e
DiffValue for a set of integers is defined as the largest possible difference among any two integers of the set. However if you choose
K
K numbers from the array, value of all the chosen numbers get multiplied by
K
K.

Hence print two integers i.e the largest value of number
K
K and largest possible
D
i
f
f
V
a
l
u
e
DiffValue corresponding to value of
K
K.

Input Format
First line contains
T
T i.e number of testcases.
For each testcase,
First line contains two space separated integers denoting
N
N and
S
S and
The next line contains
N
N space separated integers denoting the array.

Output Format
Print answer to each testcase in separate line.
For each testcase print two space separated integers denoting the value of
K
K and
D
i
f
f
V
a
l
u
e
DiffValue.

Constraints
1
<=
T
<=
100
1<=T<=100
1
<=
N
<=
50000
1<=N<=50000
1
<=
S
<=
1000000000
1<=S<=1000000000
1
<=
A
r
r
i
<=
10000
1<=Arri<=10000

Sample Input
2
5 3
1 2 3 4 5
5 15
5 4 2 7 3
Sample Output
2 2
4 12
Explanation
For testcase 1 if we choose k=2 numbers i.e {1,2}. So the numbers get transformed into {1x2,2x2} = {2,4} giving the DiffValue=2 which is <= 3. Hence answer is 2 2.




 */
import java.util.Arrays;
import java.util.Scanner;

class TestClass2 {

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        while (N-->0){
            int n=s.nextInt();
            int S=s.nextInt();
            solve(n,s,S);
        }
    }

    private static void solve(int n, Scanner s,int S) {
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }

        Arrays.sort(arr);
        Ans ans=new Ans(0);

        int k=diff(arr,0,n-1,S,ans);
        System.out.print(k+" "+ans.diffValue);
        System.out.println();



    }

    static class Ans{
        int diffValue;
        public Ans(int d){
            this.diffValue=d;
        }
    }

    private static int diff(int[] arr, int start, int end, int S, Ans ans){
        if(start>=end)
            return -1;
        int min=arr[start];
        int max=arr[end];
        int k=end-start+1;
        int diffValue=(max-min)*k;
        if(diffValue<=S){
            ans.diffValue=Math.max(diffValue,ans.diffValue);
            return k;
        }
        return Math.max(diff(arr,start+1,end,S, ans) ,diff(arr,start,end-1,S, ans));


    }
}
