import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = factorial(a) / (factorial(b) * factorial(a - b));

		
		System.out.println(sum);
	}
	
	public static int factorial(int n) {
	    int result = 1;
	    for(int i = 2; i <= n; i++) {
	        result *= i;
	    }
	    
	    return result;
	}
	
	
}
