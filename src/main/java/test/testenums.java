package test;

public class testenums {

	
	public enum Country {
		  INDIA (0), USA(1), ITALY(2);
		  
		  private int code;
		  
		  Country(int code) {
		    this.code = code;
		  }

		  public int toInt() {
		    return code;
		  }
		 
		}
	
	BinarySearchTree bst=new BinarySearchTree();
	
	public static void main(String args[]){
		System.out.println(Country.ITALY.code);
	}
}
