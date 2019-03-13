package programmers.q42841;

public class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        String baseNo ;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    baseNo = "" + i + j + k;

                    for (int l = 0; l < baseball.length; l++) {
                        if (baseball[l][1] != strikeCount("" + baseball[l][0], baseNo)) {
                            break;
                        }

                        if (baseball[l][2] != ballCount("" + baseball[l][0], baseNo)) {
                            break;
                        }

                        if (l == baseball.length -1) {
                            answer++;
                        }
                    }

                }
            }
        }

        return answer;
    }

    public int strikeCount(String baseball, String increaseNum) {
        int strike = 0;
        for (int i = 0; i < baseball.length(); i++) {
            if (baseball.charAt(i) == increaseNum.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int ballCount(String baseball, String increaseNum) {
        int ball = 0;
        String[] increaseNums = increaseNum.split("");

        for (int i = 0; i < baseball.length(); i++) {
            if (baseball.charAt(i) != increaseNum.charAt(i) ) {
                if (baseball.contains(increaseNums[i]))
                ball++;
            }
        }
        return ball;
    }
}
