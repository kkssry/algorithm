package programmers.q12899;

public class Solution {
    public String solution(int n) {
        String answer = "";
        int[] arr = {4, 1, 2};
        int a;
        while (n > 0) {
            a = n % 3;
            n = n / 3;
            if (a == 0) {
                n -= 1;
            }
            answer = arr[a] + answer;
        }
        return answer;
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
