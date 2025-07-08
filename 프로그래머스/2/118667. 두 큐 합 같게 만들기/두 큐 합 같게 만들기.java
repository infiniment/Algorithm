import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int n : queue1) {
            q1.add((long) n);
            sum1 += n;
        }

        for (int n : queue2) {
            q2.add((long) n);
            sum2 += n;
        }
        
         long target = (sum1 + sum2);
        if (target % 2 != 0) return -1;
        target /= 2;

        int maxOperation = queue1.length * 3;
        int count = 0;

        while (count <= maxOperation) {
            if (sum1 == target) return count;
            if (sum1 > target) {
                long num = q1.poll();
                sum1 -= num;
                q2.add(num);
                sum2 += num;
            } else {
                long num = q2.poll();
                sum2 -= num;
                q1.add(num);
                sum1 += num;
            }
            count++;
        }

        return -1;
        
        
    
    }
}