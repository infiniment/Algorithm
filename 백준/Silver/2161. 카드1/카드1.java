import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) q.addLast(i);

        StringBuilder sb = new StringBuilder();

        while (q.size() > 1) {
            // 1) 버림
            sb.append(q.pollFirst()).append(' ');
            // 2) 다음 카드 뒤로
            q.addLast(q.pollFirst());
        }

        // 마지막 남은 카드
        sb.append(q.pollFirst());

        System.out.print(sb.toString());
    }
}
