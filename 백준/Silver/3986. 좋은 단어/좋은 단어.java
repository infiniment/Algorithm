import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            stack.clear();

            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);

                if(!stack.isEmpty() && stack.peek() == ch){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }

            if(stack.isEmpty()){
                count++;
            }

        }

        System.out.println(count);
    }
}
