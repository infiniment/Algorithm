import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

        int[] music = new int[8]; 
		
		for(int i=0; i<music.length; i++) {
			music[i] = sc.nextInt(); 
		}
		
		String result= "";
		for(int i=0; i<music.length-1; i++) {
			if(music[i]==music[i+1]-1) {
				result = "ascending";
			}else if(music[i]==music[i+1]+1) {
				result = "descending";
			}else {
				result = "mixed";
				break;
			}
		}
		System.out.println(result);
	}
}