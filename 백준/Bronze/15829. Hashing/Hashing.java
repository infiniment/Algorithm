import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int r = 31;
		final int m = 1234567891;
		
		int l = sc.nextInt();
		String str = sc.next();
		
		
		long hashValue = 0;
		long power = 1;
		
		for(int i = 0; i < l; i++) {
		    int charValue = str.charAt(i) - 'a' + 1;
		    hashValue = (hashValue + charValue * power) % m;
		    power = (power * r) % m;
		}
		
		System.out.println(hashValue);
	}
}