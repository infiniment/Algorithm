import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // L : 커서를 왼쪽으로 한 칸 옮김. 조건 : 커서가 문장의 맨 완쪽이면 무시된다.(continue)
        // D : 커서를 오른쪽으로 한 칸 옮김. 조건 : 커서가 문장의 맨 오른쪽이면 무시된다.(continue)
        // B : 커서 왼쪽에 있는 문자를 삭제 조건 : 커서가 문장의 맨 앞이면 무시된다. (continue)
        // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 보이지만. 실제로 커서 오른쪽에 있던 문자 그대로임
        // P $ : $라는 문자 커서 왼쪽에 추가함

        // 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성
        // 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다

        // 문자열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 커서 왼쪽 스택
        Stack<Character> leftStack = new Stack<>();

        // 커서 오른쪽 스택
        Stack<Character> rightStack = new Stack<>();

        for(int i=0; i<N.length(); i++){
            leftStack.push(N.charAt(i)); // 왼쪽 커서 스택에 모든 문자들을 다 넣어둔다. 이유 : 명령어가 수행되기 전 커서는 맨 뒤에 위치하고 있으므로
        }

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            char cmd = str.charAt(0);
            if(cmd == 'L') {
                if(!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            }else if(cmd == 'D') {
                if(!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            }else if(cmd == 'B') {
                if(!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            }else {
                leftStack.push(str.charAt(2));
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }


        System.out.println(sb.toString());
    }
}
