import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		    String num = sc.nextLine();
		    
		    if(num.equals("0")) 
		        break;
		    
		    if(isPalindrome(num)) {
		        System.out.println("yes");
		    }else {
		        System.out.println("no");		        
		    }
		}
	}
	
	public static boolean isPalindrome(String str) {
	    int left = 0;
	    int right = str.length() - 1;
	    
	    while(left < right) {
	        if(str.charAt(left) != str.charAt(right)) {
	            return false;
	        }   
	        left++;
	        right--;
	    }
	    
	    return true;
	}
}