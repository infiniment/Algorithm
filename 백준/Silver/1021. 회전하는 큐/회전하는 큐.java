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
        int m = Integer.parseInt(st.nextToken());


        Deque<Integer> queue = new ArrayDeque<>();

        int result = 0;

        for(int i = 1; i <= n; i++){
            queue.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;
            for(int x : queue){
                if(x == target) break;
                idx++;
            }

            int size = queue.size();
            int left = idx;
            int right = size - idx;

            if(left <= right) {
                for(int j = 0; j < left; j++) {
                    queue.addLast(queue.pollFirst());
                    result++;
                }
            }else {
                for(int j = 0; j < right; j++) {
                    queue.addFirst(queue.pollLast());
                    result++;
                }
            }

            queue.pollFirst();
        }

        System.out.println(result);

    }
}
