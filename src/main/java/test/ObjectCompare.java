package test;

public class ObjectCompare {

	public static void main(String args[]){
		Heap h1= new Heap(10);
		Heap h2= new Heap(10);
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h1==h2);
		System.out.println(h1.equals(h2));
		String s1="Vamica";
		String s2="Vamica";
		String s3=new String("Vamica");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1==s3);
		System.out.println(s1);
		System.out.println(s3);
		System.out.println(s1.equals(s3));
	}
	
	
}
