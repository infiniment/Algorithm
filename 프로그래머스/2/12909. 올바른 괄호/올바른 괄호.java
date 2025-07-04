import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        char[] ch = s.toCharArray();
        
        for(char c : ch) {
            if(c == '(') // 열린 괄호이면 push
                stk.push(c);
            else {
                if(stk.isEmpty() || stk.pop() == c) // 스택이 비어있거나 팝한 괄호가 c와 같을 때(열린 괄호)일 때는 false
                    return false;
            }
        }

        

        return stk.isEmpty(); // 스택이 비어있는지 확인 (비어 있으면 true, 비어 있지 않으면 false 반환)
    }
}