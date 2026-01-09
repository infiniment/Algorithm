import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Doc {
        int p;
        int idx;
        Doc(int p, int idx) {
            this.p = p;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken()); // 문서의 개수
            int m =  Integer.parseInt(st.nextToken()); // 알고싶은 문서

            st = new StringTokenizer(br.readLine());

            ArrayDeque<Doc> q = new ArrayDeque<>();
            int[] cnt = new int[10]; // priority 1~9

            for(int i = 0; i < n; i++) {
                int p = Integer.parseInt(st.nextToken()); // 중요도
                q.addLast(new Doc(p, i));
                cnt[p]++;
            }


            // 현재 남아있는 최대 중요도
            int maxP = 9;
            while (maxP >= 1 && cnt[maxP] == 0) maxP--;

            int printed = 0;

            while(!q.isEmpty()) {
                Doc cur = q.pollFirst();

                // 더 높은 중요도가 남아 있으면 뒤로 보냄
                if (cur.p < maxP) {
                    q.addLast(cur);
                    continue;
                }

                printed++;
                cnt[cur.p]--;

                // 찾던 문서면 정답
                if (cur.idx == m) {
                    sb.append(printed).append('\n');
                    break;
                }

                // maxP 갱신
                while (maxP >= 1 && cnt[maxP] == 0) maxP--;
            }
        }

        System.out.println(sb);





    }
}
