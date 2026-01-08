import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");

            switch(s[0]){
                case "push":
                    q.offer(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    if(q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    if(q.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(q.peekFirst());
                    }
                    break;
                case "back":
                    if(q.isEmpty()){
                        System.out.println(-1);
                    }else {
                        System.out.println(q.peekLast());
                    }
            }

        }
    }
}
