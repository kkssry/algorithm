package programmers.q43237;

public class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int sum = 0;
        int rest = 0;
        int exceedCount = 0;

        for (int i = 0; i < budgets.length; i++) {
            sum += budgets[i];
        }

        if (sum <= M) {
            int max = budgets[0];
            for (int i = 1; i < budgets.length; i++) {
                if (max < budgets[i]) {
                    max = budgets[i];
                }
            }
            answer = max;
            return answer;
        }

        int averageBudget = M / budgets.length;

        for (int i = 0; i < budgets.length; i++) {
            if (averageBudget >= budgets[i]) {
                rest += (averageBudget - budgets[i]);
            } else {
                exceedCount++;
            }
        }

        averageBudget += (rest / exceedCount);
        exceedCount = 0;

        for (int i = 0; i < budgets.length; i++) {
            if (averageBudget < budgets[i]) {
                budgets[i] = averageBudget;
                exceedCount++;
            }
        }

        sum = 0;

        for (int i = 0; i < budgets.length; i++) {
            sum += budgets[i];
        }

        int lastRest = M - sum;
        averageBudget += lastRest / exceedCount;

        answer = averageBudget;
        return answer;
    }
}
