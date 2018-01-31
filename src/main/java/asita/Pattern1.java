package asita;

public class Pattern1 {

    public static void main(String args[]){

        for(int i=1;i<=4;i++){ //rows

            for(int k=4;k>i;k--){ //spaces
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){ //hashes
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
