import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        
        int sumWeight = 0;
        int time = 0;
        
        for(int truckWeight : truck_weights) {
            while(true) {
                if(bridge.isEmpty()) { // 다리가 빈 경우
                    bridge.add(truckWeight);
                    sumWeight += truckWeight;
                    time++;
                    break;
                }else if(bridge.size() == bridge_length) { // 다리에 올라와 있는 트럭의 개수와 다리에 있는 트럭 개수가 같은 경우 이미 다리 끝에 있는 트럭이 존재하므로 빼주면 됨
                    sumWeight -= bridge.poll();        
                }else {
                    if(sumWeight + truckWeight <= weight) {
                        bridge.add(truckWeight);
                        sumWeight += truckWeight;
                        time++;
                        break;
                    }else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }
        return time +  bridge_length; // 마지막 트럭이 건너는 시간까지 고려
    }
}