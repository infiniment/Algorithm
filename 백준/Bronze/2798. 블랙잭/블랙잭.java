import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] cards = new int[n];
		int maxSum = 0;
		
		for(int i = 0; i < cards.length; i++) {
		    cards[i] = sc.nextInt();
		}
        
        		
		for(int i = 0; i < n; i++) {
		    for(int j = i + 1; j < n; j++) {
		        for(int k = j + 1; k < n; k++) {
		            int total = cards[i] + cards[j] + cards[k];
		            if(m >= total && total > maxSum) {
		                maxSum = total;
		            }
		        }
		    }
		}
		
		System.out.println(maxSum);
	}
}