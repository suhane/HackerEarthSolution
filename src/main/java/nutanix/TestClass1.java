package nutanix;


/*
Alice has recently found an array
a
a containing
N
N integers. As we all know Alice loves sorted array so, he wants to sort the array. To sort an array Alice can add 1 to any integer in the array in 1 move.

Alice wants to find minimum number of moves needed to sort this array. Remember that after sorting the array, all elements in it should be distinct.

INPUT CONSTRAINTS

1
≤
N
≤
10
5
1≤N≤105
1
≤
a
i
≤
10
6
1≤ai≤106
INPUT FORMAT
First line of input contains a single integer
N
N.
Second line of input contains
N
N space separated inegers, elements of array
a
a.

OUTPUT FORMAT
Output a single integer, denoting number of moves needed to sort the given array.
 */
import java.util.Scanner;

class TestClass1 {

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        solve(N,s);
    }

    private static void solve(int n, Scanner s) {
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        int count=0;
        int last=arr[0];
        for (int i = 1; i < n; i++) {

            if(arr[i]<=last){
                count+=last-arr[i]+1;
                last=arr[i-1]+1;
            }
            else {
                last=arr[i];
            }
        }

        System.out.println(count);
    }
}
