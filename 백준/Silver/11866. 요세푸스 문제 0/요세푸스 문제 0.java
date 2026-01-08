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

        int n =  Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++){
            q.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!q.isEmpty()){ // 남지 않을 때까지 반복
            for(int i = 0; i < k - 1; i++) { // k - 1번째까지만 앞에서 빼서 다시 뒤로 넣기
                q.addLast(q.pollFirst());
            }
            sb.append(q.pollFirst()); // K번째 제거

            if(!q.isEmpty()) sb.append(", ");
        }

        sb.append(">");

        System.out.println(sb.toString());


    }
}
