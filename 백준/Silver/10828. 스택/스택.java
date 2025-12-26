import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 명령 수를 입력
        // 각 명령을 입력 받음

        /*
        * push X : X를 Stack에 넣는다.
        * pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 조건 : 스택이 비어있는 경우 -1 출력
        * top : 스택에서 가장 위에 있는 수를 출력한다. 조건 : 스택이 비어있는 경우 -1 출력
        * size : 스택에 들어있는 정수의 개수를 출력한다. -> count가 필요할 것 같음
        * empty : 스택이 비어있으면 1, 그 외 0 출력, boloean 타입으로 조건 true, false
        *
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 스택 생성 및 초기화
        int[] stack = new int[n]; // 최대 n번 push 가능
        int top = 0;

        // n만큼 반복
        for(int i = 0; i < n; i++) {
            String line = br.readLine();

            if(line.charAt(0) =='p') {
                if(line.length() > 3 && line.charAt(1) == 'u') {
                    int x= Integer.parseInt(line.substring(5));
                    stack[top++] = x;
                }else {
                    if(top == 0) out.append(-1).append('\n');
                    else out.append(stack[--top]).append('\n');
                }

            }else if (line.charAt(0) == 's') { // size
                out.append(top).append('\n');
            } else if (line.charAt(0) == 'e') { // empty
                out.append(top == 0 ? 1 : 0).append('\n');
            } else { // top
                if (top == 0) out.append(-1).append('\n');
                else out.append(stack[top - 1]).append('\n');
            }
        }

        System.out.println(out.toString());
    }
}
