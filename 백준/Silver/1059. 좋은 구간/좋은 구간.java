import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l =  Integer.parseInt(br.readLine());

        int[] arr = new int[l];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for (int x : arr) {
            if (x == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = 1001;

        for(int x : arr) {
            if(x < n) {
                left = x;
            }else if(x > n) {
                right = x;
                break;
            }
        }

        int aCount = n - left;
        int bCount = right - n;

        int answer = aCount * bCount - 1;
        System.out.println(answer);

    }
}
