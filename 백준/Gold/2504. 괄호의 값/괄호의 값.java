import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Object> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 여는 괄호
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }

            // 닫는 소괄호 )
            else if (ch == ')') {
                int sum = 0;

                // 숫자 먼저 전부 꺼내기
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (int) stack.pop();
                }

                // 매칭되는 '(' 확인
                if (stack.isEmpty() || (char)stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                stack.pop(); // '(' 제거

                // 값 계산 후 push
                if (sum == 0) stack.push(2);
                else stack.push(2 * sum);
            }

            // 닫는 대괄호 ]
            else if (ch == ']') {
                int sum = 0;

                // 숫자 먼저 전부 꺼내기
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (int) stack.pop();
                }

                // 매칭되는 '[' 확인
                if (stack.isEmpty() || (char)stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                stack.pop(); // '[' 제거

                // 값 계산 후 push
                if (sum == 0) stack.push(3);
                else stack.push(3 * sum);
            }
        }

        // 최종 결과 계산
        int result = 0;
        for (Object obj : stack) {
            if (!(obj instanceof Integer)) {
                System.out.println(0);
                return;
            }
            result += (int) obj;
        }

        System.out.println(result);
    }
}
