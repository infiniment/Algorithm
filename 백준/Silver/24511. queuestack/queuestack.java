import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int m =  Integer.parseInt(br.readLine());
        int[] c = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> q = new ArrayDeque<>();

        // Ai=0인 것만 오른쪽부터 넣기
        for(int i = n - 1; i >= 0; i--) {
            if(a[i] == 0)
                q.addLast(b[i]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            if(q.isEmpty()) {
                // 큐가 하나도 없으면 전부 스택 -> 입력이 그대로 출력
                sb.append(c[i]).append(' ');
            }else {
                sb.append(q.pollFirst()).append(' ');
                q.addLast(c[i]);
            }
        }

        System.out.println(sb);
    }
}
