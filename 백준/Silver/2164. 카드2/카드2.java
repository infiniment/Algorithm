import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1번이 제일 위에
        // N번이 제일 아래

        // 제일 위에 있는 카드를 버리고 그 다음 오는 카드는 맨 밑으로 보낸다. -> 반복 : 카드가 하나 남을 때까지.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        for(int i = 1; i <= num; i++){
            queue.offer(i);
        }

        while(queue.size() > 1) {
            if(count % 2 == 0) {
                int n =  queue.poll();
                queue.offer(n);
                count++;
            }
            else {
                queue.poll();
                count++;
            }
        }

        System.out.println(queue.poll());
    }
}
