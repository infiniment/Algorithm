import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 왼쪽 방향으로 레이저 신호를 발사, 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.
        // 모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자 -> 오른쪽 끝부터 시작
        // Ex) 6, 9, 5, 7, 4일 때 4부터 시작하면 왼쪽에 있는 4보다 큰 7인 탑에서 수신을 받고, 7인 5를 뛰어넘고 그 다음 7보다 큰 9에 전송한다.
        // 5는 9, 9와 6은 없으므로 0
        //  순서대로 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호 index + 1해서 출력해야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ans = new int[n];
        // stack에 [idx(1-based), height]
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 왼->오
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            int idx = i + 1;

            while (!stack.isEmpty() && stack.peek()[1] < h) {
                stack.pop();
            }

            // 남아있는 top이 있으면 그게 가장 가까운 왼쪽의 큰 탑
            ans[i] = stack.isEmpty() ? 0 : stack.peek()[0];

            stack.push(new int[]{idx, h});

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(ans[i]);
            if(i < n - 1) sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}
