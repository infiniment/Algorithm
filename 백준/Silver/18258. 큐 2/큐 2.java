import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append('\n');
                    break;

                case "size":
                    sb.append(dq.size()).append('\n');
                    break;

                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append('\n');
                    break;

                case "back":
                    sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append('\n');
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
