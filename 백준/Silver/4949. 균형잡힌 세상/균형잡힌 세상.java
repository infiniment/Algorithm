import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while(true) {
            String str = br.readLine();
            stack.clear();
            boolean flag = true;

            if(str.equals(".")) {
                break;
            }

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                }else if(str.charAt(i) == ')' || str.charAt(i) == ']') {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }

                    char top = stack.pop();

                    if (str.charAt(i) == ')' && top != '(') {
                        flag = false;
                        break;
                    }
                    if (str.charAt(i) == ']' && top != '[') {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag && stack.isEmpty()) {
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }
}
