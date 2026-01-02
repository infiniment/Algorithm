import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());             

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);

            } else if (cmd == 2) {
                if (stack.isEmpty()) sb.append(-1).append('\n');
                else sb.append(stack.pop()).append('\n');

            } else if (cmd == 3) {
                sb.append(stack.size()).append('\n');

            } else if (cmd == 4) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');

            } else if (cmd == 5) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
