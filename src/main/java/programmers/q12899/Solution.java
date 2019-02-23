package programmers.q12899;

public class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        String answer = "";
        int mock = mock(n);
        int rest = rest(n);

        while (mock != 0) {
            if (rest == 0) {
                sb.append("4");
                rest = ((mock-1) % 3);
                mock = ((mock-1) / 3);
                continue;
            }
//            answer += rest;
            sb.append(rest);
            rest = mock % 3;
            mock /= 3;
        }
        sb.append(rest);
        return Integer.parseInt(reverse(sb)) + "";
    }


    public int mock(int num) {
        return num / 3;
    }

    public int rest(int num) {
        return num % 3;
    }

    public String reverse(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
