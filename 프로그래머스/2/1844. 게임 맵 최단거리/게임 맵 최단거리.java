import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
   public int solution(int[][] maps) {
        // 상, 하, 좌, 우 순서 상관없이 4방만 신경쓰면 되므로
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = maps.length; // 세로의 길이
        int m = maps[0].length; // 가로의 길이
        boolean[][] visited = new boolean[n][m]; // 값을 poll할 때마다 check
        // 1. queue를 만들거야.
        // 2. 거기에 초기값을 집어넣어.
        // 3. queue 하나 poll해서, 4방을 확인해
        // 4. 그것들 중 갈 수 있으면 queue에 집어넣어.
        // 3, 4를 반복 -> 더이상 못할 때까지
        // 갈 수 있다 : grid안에 있다.
        //            벽이 아니다
        //            방문하지 않았다.

        // 좌표가 들어갈 예정 [x, y]
//        Node class를 만들어도 되긴 한다.
//        1.
        Deque<int[]> queue = new ArrayDeque<>();

//        2. (0, 0, distance = 1) -> 내가 적고 싶은 걸로 적어도됨. (거리는 문제마다 바라는게 다름)
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

//        3.
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            int distance = node[2];

            for (int d = 0; d < 4; d++) {
                // x, y의 4방 -> 갈 수 있으면 queue에 집어 넣을 예정이다.
                int nx = x + dx[d];
                int ny = y + dy[d];

//            if(nx, ny 가 grid 안에 있고/ 값이 벽이 아니면) {
//                queue.offer(new int[]{nx, ny});
//            }

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                 if(/ 값이 벽이 아니면)
                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, distance + 1}); // -> 이때 distance를 늘려줌
                        visited[nx][ny] = true;
                        
                        // 로직상 약간 부자연스러울 수 있음
                        if(nx == n - 1 && ny == m - 1) {
                            return distance + 1;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}