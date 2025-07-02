import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0; // 터뜨려진 인형 개수
        
        for(int move : moves) {
            int col = move - 1; // 배열은 0부터
            
            // 해당 열에서 위쪽부터 인형 찾기
            for(int row = 0; row < board.length; row++) {
                // 인형이 있는 경우
                if(board[row][col] != 0) {
                    int doll = board[row][col]; // 인형 위치 저장
                    board[row][col] = 0; // 뽑은 인형 자리를 빈 칸으로 만들기    
                    
                    // 바구니가 비어있지 않고, 맨 위 인형과 같은 모양인지 확인
                    if(!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop(); // 같은 인형이면 터뜨리기 (기존 인형 제거)
                        answer += 2;  // 터뜨려진 인형 2개 카운트
                    }else {
                        basket.push(doll);
                    }
                    
                    break;
                }
                
            }
            
        }
        
        return answer;
    }
}