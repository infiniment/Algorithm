import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {   
        Set<String> phoneSet = new HashSet<>();
        
        for(String num : phone_book) {
            phoneSet.add(num);
        }
        
        
        for (String num : phone_book) {
            for(int i = 1; i < num.length(); i++) {
                String prefix = num.substring(0, i);
                if(phoneSet.contains(prefix)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}