import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        Arrays.sort(lost);
        
        for(int l : lost) {
            lostSet.add(l);
        }
        
        for(int r : reserve) {
            if(lostSet.contains(r)) {
                lostSet.remove(r);
            }else {
                reserveSet.add(r);
            }
        }
        
        for(int l : lost) {
            if(lostSet.contains(l)) {
                if(reserveSet.contains(l - 1)) {
                    reserveSet.remove(l - 1);
                    lostSet.remove(l);
                }else if(reserveSet.contains(l + 1)) {
                    reserveSet.remove(l + 1);
                    lostSet.remove(l);
                }
            }
        }
        
        return n - lostSet.size();
    }
}