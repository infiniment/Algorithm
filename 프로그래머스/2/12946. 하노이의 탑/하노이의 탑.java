import java.util.List;
import java.util.ArrayList;

class Solution {
    List<int[]> moves = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2); 
        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }
        return answer;
    }
    
    // 하노이 재귀 함수
    private void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, via, to);
        moves.add(new int[]{from, to}); 
        hanoi(n - 1, via, to, from); 
    }
}
