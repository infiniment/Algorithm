import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        * 먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
        * 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
        * 문자열의 시작과 끝은 공백이 아니다.
        * '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
        * 태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고,
        *  <'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
        * 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean inTag = false;
        StringBuilder word = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '<') {
                if(word.length() > 0) {
                    sb.append(word.reverse());
                    word.setLength(0);
                }

                inTag = true;
                sb.append(ch);
            }else if(ch == '>') {
                inTag = false;
                sb.append(ch);
            }else if(inTag) {
                // 태그 안은 그대로 출력
                sb.append(ch);
            }else {
                // 태그 밖
                if(ch == ' ') {
                    // 단어 끝 -> 뒤집어 출력 후 공백 출력
                    if(word.length() > 0) {
                        sb.append(word.reverse());
                        word.setLength(0);
                    }
                    sb.append(' ');
                }else {
                    word.append(ch);
                }
            }
        }

        // 마지막 단어 처리
        if (word.length() > 0) {
            sb.append(word.reverse());
            word.setLength(0);
        }

        System.out.println(sb.toString());

    }

}
