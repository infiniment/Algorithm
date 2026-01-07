import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int need = 1;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() == need) {
                stack.pop();
                need++;
            }

            if(num == need) {
                need++;
            }else {
                stack.push(num);
            }
        }

        while(!stack.isEmpty() && stack.peek() == need){
            stack.pop();
            need++;
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}
