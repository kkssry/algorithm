package programmers.q12979;

public class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int mock = (stations[0] - 1 - w) / (w * 2 + 1);
        int rest = (stations[0] - 1 - w) % (w * 2 + 1);
        answer += count(rest, mock);

        mock = (n - stations[stations.length - 1] - w) / (w * 2 + 1);
        rest = (n - stations[stations.length - 1] - w) % (w * 2 + 1);
        answer += count(rest, mock);


        for (int i = 1; i < stations.length; i++) {
            mock = (stations[i] - stations[i - 1] - 1 - (w * 2)) / (w * 2 + 1);
            rest = (stations[i] - stations[i - 1] - 1 - (w * 2)) % (w * 2 + 1);
            answer += count(rest, mock);
        }

        return answer;
    }

    private int count(int rest, int mock) {
        if (rest >= 0) {
            if (rest != 0) {
                mock += 1;
            }
        }
        return mock;
    }

}
