import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 작업들을 요청 시간 기준으로 정렬
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1]); // 작업 대기 큐
        
        int currentTime = 0;
        int index = 0; // jobs 배열의 포인터
        int totalTurnaroundTime = 0;
        int count = 0;
        
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(jobs[index]);
                index++;
            }
            
            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                int requestTime = job[0];
                int duration = job[1];
                
                currentTime += duration;
                totalTurnaroundTime += (currentTime - requestTime);
                count++;
            }else {
                currentTime = jobs[index][0];
            }
        }
        
        return totalTurnaroundTime / jobs.length;
    }
}