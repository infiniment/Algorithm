import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
	    
	    int mult = a * b * c;
	    
	    int[] numCntArr = new int[10];
	    
	    
	    
	    while(mult > 0) {
	        numCntArr[mult % 10]++;
	        mult /= 10;
	    }
	    
	    for(int i = 0; i < 10; i++) {
	        System.out.println(numCntArr[i]);
	    }
	    
	}
}