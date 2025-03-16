import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        
        for(int i = 0; i < t; i++) {
            int r = sc.nextInt();
            String str = sc.next();
            
            for(int j = 0; j < str.length(); j++) {
                for(int k = 0; k < r; k++) {
                    System.out.print(str.charAt(j));
                }
            }
            
            System.out.println();
        }
	    
	}
}