import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        int temp = num;
        int count = 0;
        
        while(temp > 0) { //자리수 구할 때 쓰는 것
            temp /= 10;
            count++;
        }
        
        int start = Math.max(1, num - (count * 9));
        boolean flag = false;
        
        for(int i = start; i < num; i++) {
            int sum = i;
            int tempNum = i;
            
            while(tempNum > 0) {
                sum += tempNum % 10;
                tempNum /= 10;
            }
            if(sum == num) {
                System.out.println(i);
                flag = true;
                break;
            }
        }
        
        if(!flag) {
            System.out.println(0);
        }
	}
}