import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int prec(char op) {
        if(op == '*' || op == '/') return 2;
        if(op == '+' || op == '-') return 1;
        return 0; // '('인 경우
    }
    public static void main(String[] args) throws IOException {
        /*
        *
        * 1. 피연산자는 그대로 출력합니다.
        * 2. 연산자는 스택이 비어있으면 자신을 바로 추가합니다.
        * 3. stack의 top이 자신보다 우선순위가 낮은 연산자를 만날 때까지 pop 하고 자신을 담습니다.
        * 4. 단, 여는 괄호는 닫는 괄호가 아니면 pop하지 않습니다.
        * 4. 닫는 괄호가 나오면 여는 괄호가 나올 때까지 꺼내서 출력합니다.
        * 5. 마지막에 도착하면 스택에서 차례로 꺼내서 출력합니다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            // 1) 피연산자: 바로 출력
            if ('A' <= ch && ch <= 'Z') {
                sb.append(ch);
            } else if(ch == '(') {
                stack.push(ch);
            }else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }

            }else {
                while (!stack.isEmpty() && stack.peek() != '('
                    && prec(stack.peek()) >= prec(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
