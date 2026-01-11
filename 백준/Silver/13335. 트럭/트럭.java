import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =  Integer.parseInt(st.nextToken());
        int w =  Integer.parseInt(st.nextToken());
        int l =  Integer.parseInt(st.nextToken());

        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < w; i++) {
            q.offer(0);
        }

        int time = 0;
        int idx = 0;
        int sum = 0;

        while(idx < n || sum > 0) {
            time++;

            // 1칸 이동 : 큐 맨 앞이 빠짐
            sum -= q.poll();

            // 다음 트럭 올릴 수 있으면 올리기
            if(idx < n && sum + truck[idx] <= l) {
                q.offer(truck[idx]);
                sum += truck[idx];
                idx++;
            }else {
                q.offer(0);
            }
        }

        System.out.println(time);

    }
}
