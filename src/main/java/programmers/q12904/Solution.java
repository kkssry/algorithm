package programmers.q12904;

public class Solution {
    public int solution(String s) {
        int answer = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            int temp;
            for (int j = i + 1; j < s.length(); j++) {
                if (isPellin(s, i, j)) {
                    temp = pellinCount(s, i, j);
                    if (answer < temp) {
                        answer = temp;
                    }
                }
            }

        }

        return answer;
    }

    private int pellinCount(String s, int i, int j) {
        int count;
        count = s.substring(i, j + 1).length();
        return count;
    }

    private boolean isPellin(String s, int i, int j) {
        if (s.charAt(i) == s.charAt(j)) {
            return comparison(s,i,j);
        }
        return false;
    }

    private boolean comparison(String s, int i, int j) {
        String extract = s.substring(i,j+1);
        int length = extract.length();

        for (int k = length - 1; k >= length/2; k--) {
            if (extract.charAt(k) != extract.charAt(length - k - 1)) {
                return false;
            }
        }
        return true;
    }

}
