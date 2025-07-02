import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stageCounts = new int[N + 2];
        List<double[]> failList = new ArrayList<>();
        int[] answer = new int[N];

        int total = stages.length;

        for (int s : stages) {
            stageCounts[s]++;
        }

        for (int i = 1; i <= N; i++) {
            int failed = stageCounts[i];
            double failRate = 0.0;

            if (total > 0) {
                failRate = (double) failed / total;
            }

            failList.add(new double[]{i, failRate});
            total -= failed;
        }

        // 실패율 내림차순, 스테이지 번호 오름차순
        Collections.sort(failList, (a, b) -> {
            if (Double.compare(b[1], a[1]) != 0)
                return Double.compare(b[1], a[1]);
            return (int)(a[0] - b[0]);
        });

        for (int i = 0; i < N; i++) {
            answer[i] = (int) failList.get(i)[0];
        }

        return answer;
    }
}
