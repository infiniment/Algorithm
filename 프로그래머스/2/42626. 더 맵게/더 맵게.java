import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        
        
        while(pq.peek() < K) {
            if(pq.size() < 2)
                return -1;
            int newScoville = (pq.poll()) + (pq.poll()  * 2);
            pq.offer(newScoville);
            count++;
        }
        
    
        
        return count;
    }
}