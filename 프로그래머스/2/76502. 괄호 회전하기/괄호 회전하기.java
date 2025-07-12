import java.util.Stack;

class Solution {
    public int solution(String s) {
        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) count++;
        }

        return count;
    }
    
    private boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) 
                    return false;
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}