import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long r1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            long r2 = Long.parseLong(st.nextToken());

            long dx = x1 - x2;
            long dy = y1 - y2;

            long d2 = dx * dx + dy * dy;
            long sum = r1 + r2;
            long sum2 = sum * sum;

            long diff = r1 - r2;
            long diff2 = diff * diff;

            int ans;

            if(d2 == 0){
                if (r1 == r2) ans = -1;
                else ans = 0;
            }else {
                if (d2 > sum2) ans = 0;
                else if (d2 < diff2) ans = 0;
                else if (d2 == sum2) ans = 1;
                else if (d2 == diff2) ans = 1;
                else ans = 2;
            }
            sb.append(ans).append('\n');

        }
            System.out.print(sb);



    }
}
