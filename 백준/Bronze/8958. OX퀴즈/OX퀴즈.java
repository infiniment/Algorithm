import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int streak = 0;
		int sum = 0;
		
		for(int i = 0; i < t; i++) {
		    String str = sc.next();
		    for(int j = 0; j < str.length(); j++) {
		        if(str.charAt(j) == 'O') {
		            streak++;
		            sum += streak;
		        }else if(str.charAt(j) == 'X') {
		            streak = 0;
		        }
		    }
		    System.out.println(sum);
		    streak = 0;
		    sum = 0;
		}
		
	
	}
}