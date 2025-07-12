import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();

        for(String str : completion) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        
        for(String str : participant) {
            if(hm.getOrDefault(str, 0) == 0) {
                return str;
            }
            hm.put(str, hm.get(str) - 1);
        }
        
        return null;
    }
}