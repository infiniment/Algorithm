import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int buffer = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == -1) break;

            if(n == 0) {
                if(!q.isEmpty()) q.poll();
            }else {
                if(q.size() < buffer) q.offer(n);
            }



        }

        StringBuilder sb = new StringBuilder();

        if(q.isEmpty()) {
            System.out.println("empty");
            return;
        }
        while (!q.isEmpty()) {
            sb.append(q.poll());
            if (!q.isEmpty()) sb.append(' ');
        }


        System.out.println(sb);
    }
}
