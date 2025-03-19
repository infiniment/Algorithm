import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] sizes = new int[6];
        
        
        for(int i = 0; i < sizes.length; i++) {
            sizes[i] = sc.nextInt();
        }
        
        int t = sc.nextInt();
        int p = sc.nextInt();
        
        int tCnt = 0;
        for(int i = 0; i < sizes.length; i++) {
            tCnt += (sizes[i] / t) + (sizes[i] % t == 0 ? 0 : 1);
        }
        
        System.out.println(tCnt);
        System.out.println(n / p + " " + n % p);
        
	}
}