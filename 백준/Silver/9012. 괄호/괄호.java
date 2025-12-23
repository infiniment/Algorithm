import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String s = br.readLine().trim();
            Stack<Character> st = new Stack<>();
            boolean valid = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    st.push(c);
                } else { // c == ')'
                    if (st.isEmpty()) {
                        valid = false;
                        break;
                    }
                    st.pop();
                }
            }

            if (valid && st.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }
}
