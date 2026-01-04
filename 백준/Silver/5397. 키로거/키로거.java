import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표이다.

        // 첫째 줄에 테스트 케이스의 개수가 주어진다

        // 각 테스트 케이스는 한 줄로 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (강산이가 백스페이스를 입력했다면, '-'가 주어진다)
        // 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다. 화살표의 입력은 '<'와 '>'로 주어진다.
        // 커서의 위치는 1만큼만 움직인다.


        // 스택 두 개 필요 커서 기준 왼쪽 스택, 오른쪽 스택

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (ch == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (ch == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(ch);
                }
            }

            // 출력 만들기
            for (char ch : leftStack) {
                result.append(ch);
            }
            while (!rightStack.isEmpty()) {
                result.append(rightStack.pop());
            }
            result.append('\n');
        }

        System.out.print(result.toString());

    }
}
