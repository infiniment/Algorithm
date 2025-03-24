import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	
    	System.out.println(gcd(a, b));
    	System.out.println(lcm(a, b));
	}
	
	public static int gcd(int a, int b) {
	    if(b == 0) {
	        return a;
	    }  
	    return gcd(b, a % b);
	}
	
	public static int lcm(int a, int b) {
	    int num = gcd(a, b);
	    return a * b / num;
	}
}
