package test;

public class Misc {
public static int[] addOnetoNumber(int[] digits,int toAdd){
	int l=digits.length;
	for(int i=l-1;i>=0;i--){
		int temp=digits[i];
		digits[i]=(digits[i]+toAdd)%10;
		toAdd=(temp+toAdd)/10;
		
	}
	if(toAdd!=0){
		int[] result=new int[l+1];
		System.arraycopy(digits, 0, result, 1, l);
		result[0]=toAdd;
		return result;
	}
	return digits;
}

public static int equilibrium(int[] A){
	int leftsum=0,l=0,sum=0;
	for(int data:A){
		l++;
		sum+=data;
	}
	for(int i=0;i<l;i++){
		sum-=A[i];
		if(sum==leftsum){
			return i;
		}
		leftsum+=A[i];
	}
	return -1;
}

public static void printSpiral(int[][] A, int m,int n ){
	int rowStart=0,columnstart=0,rowend=m-1,columnend=n-1;
	
	while(rowStart<=rowend && columnstart<=columnend){
	for(int i=rowStart,j=columnstart;j<=columnend;j++){
		System.out.println(A[i][j]+" ");
	}
	for(int i=rowStart+1,j=columnend;i<=rowend;i++){
		System.out.println(A[i][j]+" ");
	}
	for(int i=rowend,j=columnend-1;j>=columnstart;j--){
		System.out.println(A[i][j]+"");
	}
	for(int i=rowend-1,j=columnstart;i>rowStart;i--){
		System.out.println(A[i][j]+"");
	}
	rowStart++;columnstart++;rowend--;columnend--;
	}

}

public static void driverForaddOnetoNumber(){
	int[] digits={9,9,9,9,9};
	int[] result=addOnetoNumber(digits,9);
	for(int digit:result){
		System.out.print(digit);
	}
	System.out.println();
}
public static void driverForequilibrium(){
	int[] digits={-7,1,5,2,-4,3,0};
	int result=equilibrium(digits);
		System.out.print(result);
}

public static void driverForprintSpiral(){
	int[][] A= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++)
			System.out.print(A[i][j]+" ");
	System.out.println();
	}
	printSpiral(A, 4, 4);
}

public static void main(String args[]){
	
	
}
}
