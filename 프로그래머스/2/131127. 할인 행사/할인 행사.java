import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
    
        int answer = 0; 
        
        for(int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discountItemMap = new HashMap<>();
            for(int j = i; j < i + 10; j++) {
                if(wantMap.containsKey(discount[j])) {
                    discountItemMap.put(discount[j], discountItemMap.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if(discountItemMap.equals(wantMap))
                answer++;
        }
        return answer;
    }
}