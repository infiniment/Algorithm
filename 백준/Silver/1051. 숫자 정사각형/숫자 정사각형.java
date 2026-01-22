import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int maxK = Math.min(n, m);

        for(int k = maxK; k >= 1; k--) {
            for(int i = 0; i + k - 1 < n; i++) {
                for(int j = 0; j + k - 1 < m; j++) {
                    char a = grid[i][j];
                    if(a == grid[i][j + k - 1] && a == grid[i + k - 1][j] && a == grid[i + k - 1][j + k - 1]) {
                        System.out.println(k * k);
                        return;
                    }
                }
            }
        }
    }
}
