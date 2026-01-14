import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++){
            list.add(i);
        }

        int cur = 0;

        for (long t = 1; list.size() > 1; t++) {
            int m = list.size();

            long k = t * t * t;
            long move = (k - 1) % m; // 현재 포함해서 세므로 - 1
            int removeIdx = (int)((cur + move) % m);

            list.remove(removeIdx);
            if (list.size() == 1) break;
            cur = removeIdx % list.size(); // 제거한 사람 다음(시계방향)이 시작점
        }

        System.out.println(list.get(0));

    }
}
