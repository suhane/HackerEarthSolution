package thoughtworks;


/*
Question1Max. Marks 100.00
Countries Grouping
People in the group, are sitting in a row numbered from
1
1 to
N
N. Every person have been asked with a same question as

How many people of your country are there in the group?
The answers provided may be incorrect. It is known that people of same countries always sit together.

If all the given answers are correct, determine the number of distinct countries present otherwise print "Invalid Data".

Input

First line contains one integer, which denotes the number of test cases

Each test case consists of 2 lines:

The first line contains one integer
N
N, which denotes the total number of people there in the group.

The second line contains
N
N space-separated integers say
A
i
Ai , which denotes the answer given by the
i
t
h
ith person.

Output

For each test case output a single line containing a single integer denoting the distinct countries or "Invalid Data".

Constraints:

1
≤
T
≤
1000
1≤T≤1000
1
≤
N
≤
100
1≤N≤100
1
≤
A
i
≤
1000
1≤Ai≤1000
Sample Input
4
2
1 1
2
1 3
7
1 1 2 2 3 3 3
7
7 7 7 7 7 7 7
Sample Output
2
Invalid Data
4
1
Explanation
First test case, there are two people each from different country.

Second test case, there are only two people but the the second person claims as there are three people of his country.


 */
import java.util.Scanner;

class TestClass1 {

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        while (N-->0){
            int n=s.nextInt();
            solve(n,s);
        }
    }

    private static void solve(int n, Scanner s) {
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=s.nextInt();
        }
        int count=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>n || arr[i]<1){
                System.out.println("Invalid Data");
                return;
            }
            int num=arr[i];
            int j=1;
            while(j<num){
                if(arr[i++]!=num){
                    System.out.println("Invalid Data");
                    return;
                }
                j++;
            }
            count++;
        }

        System.out.println(count);
    }
}
