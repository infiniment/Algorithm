import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int r, c;
        Pos(int r, int c) { this.r = r; this.c = c; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean[][] apple = new boolean[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple[r][c] = true;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, Character> turn = new HashMap<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0); // 'L' or 'D'
            turn.put(x, c);
        }

        // 0=오른쪽, 1=아래, 2=왼쪽, 3=위
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;

        Deque<Pos> body = new ArrayDeque<>();
        boolean[][] snake = new boolean[n + 1][n + 1];

        body.addLast(new Pos(1, 1));
        snake[1][1] = true;

        int time = 0;

        while (true) {
            time++;

            Pos head = body.peekLast();
            int nr = head.r + dr[dir];
            int nc = head.c + dc[dir];

            // 벽 충돌
            if (nr < 1 || nr > n || nc < 1 || nc > n) {
                System.out.println(time);
                return;
            }

            // 자기 몸 충돌 (꼬리 예외 없음이 정답 처리)
            if (snake[nr][nc]) {
                System.out.println(time);
                return;
            }

            // 머리 이동(추가)
            body.addLast(new Pos(nr, nc));
            snake[nr][nc] = true;

            // 사과 있으면 꼬리 유지, 없으면 꼬리 제거
            if (apple[nr][nc]) {
                apple[nr][nc] = false;
            } else {
                Pos tail = body.pollFirst();
                snake[tail.r][tail.c] = false;
            }

            // X초 끝난 뒤 방향 전환 (이동 처리 후)
            if (turn.containsKey(time)) {
                char t = turn.get(time);
                if (t == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }
        }
    }
}
