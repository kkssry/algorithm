package programmers.school.week2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int timeCount = 0;
            for (int j = i+1; j < prices.length; j++) {
                ++timeCount;
                answer[i] = timeCount;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }
}
