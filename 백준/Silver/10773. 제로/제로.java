import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        // K 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();

        // 조건 : 0이 들어오면 stack에 넣은 것 중 맨 위 top의 값을 버린다. pop

        // K만큼 반복
        for(int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(n);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
