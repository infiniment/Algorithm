import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        // n 만큼의 수열을 만들어야 하는데
        // stack에 1부터 순서대로 넣으면서 입력한 숫자를 pop하기 위해 앞에 낮은 숫자를 먼저 push
        // 해당 숫자가 나오면 pop 이때, next <= x라면 x를 스택에 올릴 때까지 차리로 push
        // 그 다음 pop 해서 x를 꺼냄 그 후 pop 기록
        // 만약 next > x라면 (x는 이미 예전에 push된 적 있는 숫자)
        // 이제 할 수 있는건 pop뿐인데 스택 맨 위가 x면 pop 그게 아니면 NO 출력

        StringBuilder sb = new StringBuilder();
        int next = 1;
        for(int i = 1; i <= n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(next > x) {
                if(!stack.isEmpty() && stack.peek() == x) {
                    stack.pop();
                    sb.append("-\n");
                    continue;
                }else {
                    System.out.println("NO");
                    return;
                }
            }

            while(next <= x) {
                stack.push(next);
                sb.append("+\n");
                next++;
            }

            if(!stack.isEmpty() && stack.peek() == x) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}
