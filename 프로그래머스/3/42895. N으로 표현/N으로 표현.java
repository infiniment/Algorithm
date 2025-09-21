import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // setList[i] = N을 i번 사용해서 만들 수 있는 모든 수의 집합
        List<Set<Integer>> setList = new ArrayList<>();
        for (int i = 0; i <= 8; i++) { // 0~8 (문제 조건: 8을 넘으면 -1)
            setList.add(new HashSet<>());
        }

        // 1회: {N}
        setList.get(1).add(N);

        // 2~8회
        for (int i = 2; i <= 8; i++) {
            Set<Integer> cur = setList.get(i);

            // 붙여쓰기 숫자 (예: N=5, i=3 -> 555)
            int concat = Integer.parseInt(String.valueOf(N).repeat(i));
            cur.add(concat);

            // 조합: j + (i - j)
            for (int j = 1; j < i; j++) { // j < i로 S0 조합 회피
                Set<Integer> A = setList.get(j);
                Set<Integer> B = setList.get(i - j);

                for (int a : A) {
                    for (int b : B) {
                        cur.add(a + b);
                        cur.add(a - b);
                        cur.add(a * b);
                        if (b != 0) cur.add(a / b); // 분모만 0 아님 체크
                    }
                }
            }

            // i단계에서 바로 정답 확인 후 조기 종료
            if (cur.contains(number)) return i;
        }

        // 모든 단계 계산 후에도 없으면 -1
        return -1;
    }
}
