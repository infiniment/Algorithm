import java.util.List;
import java.util.ArrayList;

class Solution {
//     List<int[]> moves = new ArrayList<>();
    
//     public int[][] solution(int n) {
//         hanoi(n, 1, 3, 2); 
//         int[][] answer = new int[moves.size()][2];
//         for (int i = 0; i < moves.size(); i++) {
//             answer[i] = moves.get(i);
//         }
//         return answer;
//     }
    
//     // 하노이 재귀 함수
//     private void hanoi(int n, int from, int to, int via) {
//         if (n == 1) {
//             moves.add(new int[]{from, to});
//             return;
//         }
//         hanoi(n - 1, from, via, to);
//         moves.add(new int[]{from, to}); 
//         hanoi(n - 1, via, to, from); 
//     }
    List<int[]> answer = new ArrayList<int[]>();

    public int[][] solution(int n) {
//        String => toArray(String[]::new);
        hanoi(1, 3, 2, n);
        return answer.toArray(new int[0][]);
    }
    void hanoi(int start, int target, int tmp, int n) {
        if(n == 1) {
            answer.add(new int[]{start, target});
            return;
        }
        // start -> tmp
//        hanoi(n - 1);
        hanoi(start, tmp, target, n - 1);
        // start -> target
//        1 ->
        answer.add(new int[]{start, target});
        //
//        hanoi(n - 1);
        hanoi(tmp, target, start, n - 1);
    }
}
