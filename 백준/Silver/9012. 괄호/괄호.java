import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // T개의 테스트 데이터로 주어진다.
        // count를 세는 변수를 하나 생성한다. 초기화
        // "("이면 count++, ")"이면 count--
        // 끝까지 다 돌았을 때 count가 0이면 "YES" 출력, 그 외 "NO" 출력
        // T만큼 반복
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            boolean invalid = false;
            count = 0;
            for(Character c : str.toCharArray()) {
                if(c == '(') {
                    count++;
                }else if(c == ')') {
                    count--;
                    if(count < 0) {
                        invalid = true;
                        break;
                    }
                }
            }

            if(!invalid && count == 0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }


    }
}
