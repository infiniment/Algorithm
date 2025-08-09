import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();

        for (int num : win_nums) {
            winSet.add(num);
        }

        int zeroCount = 0; 
        int matchCount = 0; 

        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winSet.contains(num)) {
                matchCount++;
            }
        }
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; 
        int best = rank[matchCount+zeroCount];
        int worst = rank[matchCount];
        return new int[]{best, worst};
        
    }
}