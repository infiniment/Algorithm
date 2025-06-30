import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        
        // 점수 계산
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < pattern.length; j++) {  // 조건문 수정
                if(answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;  // j번째 수포자 점수 증가
                }
            }
        }
        
        // 최고점수 찾기
        int maxScore = Math.max(Math.max(scores[0], scores[1]), scores[2]);
        
        // 최고점수를 받은 사람들 찾기 (ArrayList 활용)
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == maxScore) {
                result.add(i + 1);  // 수포자 번호는 1부터 시작
            }
        }
        
        // List를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}