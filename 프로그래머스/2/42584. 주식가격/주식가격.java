import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stk = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // 가격이 떨어지는 순간이 오면
            while(!stk.isEmpty() && prices[i] < prices[stk.peek()]) {
                int prevIndex = stk.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stk.push(i);
        }    
        
        while (!stk.isEmpty()) {
            int idx = stk.pop();
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}