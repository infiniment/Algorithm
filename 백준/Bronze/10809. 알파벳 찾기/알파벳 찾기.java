import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int[] arr = new int[26];
		
		Arrays.fill(arr, -1);
		
		for(int i = 0; i < str.length(); i++) {
		    int index = str.charAt(i) - 'a';
		    if(arr[index] == -1) {
		        arr[index] = i;
		    }
		}
		
		for(int i = 0; i < 26; i++) {
		    System.out.print(arr[i] + " ");
		}
		
	
	}
}