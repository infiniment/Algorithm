import java.util.Stack;

class Solution
{
    public int solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(stk.isEmpty()) {
                stk.push(c);
            }else {
                if(c == stk.peek()){ // top이 가리키는 값과 비교
                    stk.pop();
                }else {
                    stk.push(c);
                }
            }
        }
        
        if(stk.isEmpty()) {
            return 1;
        }else {
            return 0;
        }
       
    }
}