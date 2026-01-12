import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();

        int[] count = new int[21];

        long answer = 0;

        for(int i = 0; i < n; i++){
            int len = br.readLine().length();

            if(q.size() > k) {
                int oldLen = q.pollFirst();
                count[oldLen]--;
            }

            answer += count[len];

            q.addLast(len);
            count[len]++;
        }

        System.out.println(answer);
    }
}
