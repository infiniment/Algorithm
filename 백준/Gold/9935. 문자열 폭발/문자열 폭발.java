import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        * 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
            새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다. (if)
            폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다. (while)
            * 남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다. (false일 경우)
        * */

        // 조건 : 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String bomb = br.readLine();
        int bombLen = bomb.length();
        char last = bomb.charAt(bombLen - 1);

        // 문자 하나씩 담을 곳
        char[] stack = new char[str.length()];

        // 탑 포인터
        int top = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            stack[top++] = ch;

            if (ch == last && top >= bombLen) {
                boolean match = true;

                for(int j = 0; j < bombLen; j++) {
                    if(stack[top - bombLen + j] != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if(match) {
                    top -= bombLen;
                }
            }

        }

        if(top == 0) {
            System.out.println("FRULA");
        }else {
            System.out.println(new String(stack, 0, top));
        }
    }
}
