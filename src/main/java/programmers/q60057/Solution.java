package programmers.q60057;

public class Solution {
    public int solution(String s) {
        int answer = 1000;
        StringBuilder sb = new StringBuilder();
        String cutString;
        String cut;
        int count;
        int mock;

        for (int i = 1; i < s.length(); i++) {
            sb.setLength(0);
            count = 0;
            mock = s.length() / i;
            cutString = s.substring(0, i);
            sb.append(cutString);
            for (int j = i; j < mock * i; j += i) {
                cut = s.substring(j, j + i);
                if (cutString.equals(cut)) {
                    count++;
                } else {
                    if (count > 0) {
                        sb.append(count + 1);
                        count = 0;
                    }
                    cutString = cut;
                    sb.append(cutString);
                }
            }
            if (count > 0) {
                sb.append(count + 1);
            }
            sb.append(s.substring(i * mock));
            System.out.println(sb.toString());
            if (sb.length() < answer) {
                answer = sb.length();
            }
        }

        return answer;
    }
}
