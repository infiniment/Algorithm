import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int maxIndex = 0;
	    int maxNumber = 0;
	    
	   for(int i = 0; i < 9; i++) {
	       int number = sc.nextInt();
	       if(number > maxNumber) {
	           maxNumber = number;
	           maxIndex = i + 1;
	       }
	   }
	   
	   System.out.println(maxNumber);
	   System.out.println(maxIndex);
	}
}