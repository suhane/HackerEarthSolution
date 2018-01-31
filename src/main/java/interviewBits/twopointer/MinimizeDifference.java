package interviewBits.twopointer;

import java.util.ArrayList;

/**
 * Created by labuser on 7/24/17.
 * Given three sorted arrays A, B and Cof not necessarily same sizes.

 Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
 i.e. minimize | max(a,b,c) - min(a,b,c) |.

 A : [ 1, 4, 5, 8, 10 ]
 B : [ 6, 9, 15 ]
 C : [ 2, 3, 6, 6 ]

 Output:

 1
 Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
public class MinimizeDifference {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int a=A.size()-1;
        int b=B.size()-1;
        int c=C.size()-1;

        //calculating minimum MAX(a,b,c)

        int ans=Integer.MAX_VALUE;

        int r =Math.min(a,Math.min(b,c));

        while(r>=0){
            int max=Math.max(A.get(a),Math.max(B.get(b),C.get(c)));
            int min=Math.min(A.get(a),Math.min(B.get(b),C.get(c)));
            ans=Math.min(ans,Math.abs(max-min));
            if(max==A.get(a)){
                a--;
                r=a;

            }
            else if(max==B.get(b)){
                b--;
                r=b;
            }
            else{
                c--;
                r=c;
            }

        }

    return ans;
    }

    public  static void main(String args[]){
        int[] arr={52, 94, 109, 149, 186, 214, 218, 235, 236, 285, 324, 352, 390, 393, 409, 445, 485, 498, 545, 582, 625, 630, 643, 657, 690, 731, 757, 783, 806, 807, 856, 895, 895, 916, 944, 987, 997, 1033, 1054, 1084, 1110, 1140, 1150, 1176, 1208, 1231, 1237, 1239, 1261, 1307, 1336, 1374, 1394, 1429, 1457, 1503, 1529, 1542, 1547, 1571, 1591, 1624, 1629, 1671, 1687, 1723, 1743};
        ArrayList<Integer> A=new ArrayList<Integer>();

        for(int x:arr){
            A.add(x);
        }

        int[] arr2={ -255, -245, -218, -206, -181, -157, -113, -84, -41, -40, -37, 12, 22, 68, 98, 132, 153, 188, 203, 209, 255, 284, 294, 307, 336, 336, 368, 406, 443, 459, 488, 532, 563, 578, 619, 630, 648, 653, 657, 698, 729, 757, 759, 805, 836, 862, 886, 912, 931, 962, 990, 1033, 1067, 1114, 1149, 1186, 1225, 1274, 1287, 1287, 1321, 1361, 1392, 1430, 1435, 1459, 1491, 1503, 1530, 1552, 1598, 1626, 1638, 1658, 1697, 1710, 1748, 1793, 1798, 1798, 1822, 1854, 1871, 1906, 1918, 1961, 1971, 2016, 2052, 2080, 2112, 2137, 2158, 2177, 2202};
        ArrayList<Integer> B=new ArrayList<Integer>();

        for(int x:arr2){
            B.add(x);
        }
        int[] arr3={24, 49, 62, 78, 91, 135, 136, 136, 185, 213, 221, 231, 265, 276, 292, 311, 311, 341, 341, 375, 403, 424, 462, 490, 514, 553, 575, 618, 629, 658, 667, 701, 747, 761, 778, 814, 837, 844, 867, 913, 943, 951, 984, 1026, 1034, 1060, 1066, 1070, 1089, 1121, 1126, 1141, 1188, 1225, 1236, 1270, 1278, 1313, 1335, 1362, 1401, 1406, 1429, 1457, 1487, 1527, 1551, 1600, 1619, 1667, 1712, 1751, 1782, 1831, 1870, 1892, 1905, 1926, 1948, 1975, 2006, 2036, 2060, 2079};
        ArrayList<Integer> C=new ArrayList<Integer>();

        for(int x:arr3){
            C.add(x);
        }

        System.out.print(solve(A,B,C));
    }
}
