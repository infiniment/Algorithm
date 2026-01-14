import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 앵무새 수 만큼 동적으로 증가할 수 있게 List 사용
        List<Queue<String>> parrots = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            Queue<String> queue = new LinkedList<>(); // 각 앵무새가 말하는 말을 집어넣는 큐
            if(!line.isEmpty()){
                StringTokenizer st = new StringTokenizer(line);
                while(st.hasMoreTokens()){
                    queue.offer(st.nextToken());
                }

                parrots.add(queue);
            }
        }

        String l = br.readLine();
        StringTokenizer stL = new StringTokenizer(l);

        while(stL.hasMoreTokens()){
            String w = stL.nextToken();
            boolean matched = false;

            for(int i = 0; i < parrots.size(); i++){
                Queue<String> q = parrots.get(i);
                if(!q.isEmpty() && q.peek().equals(w)){
                    q.poll();
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                System.out.println("Impossible");
                return;
            }
        }

        for(Queue<String> q : parrots){
            if(!q.isEmpty()){
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}
