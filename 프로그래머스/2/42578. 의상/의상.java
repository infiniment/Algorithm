import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] clothe : clothes) {
            // clothe = {이름, 타입}
            String key = clothe[1]; // 이름을 key로 지정
            
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int answer = 1;
        
        for(Integer value : map.values()) {
            answer *= (value + 1);
        }
        
        return answer - 1;
    }
}