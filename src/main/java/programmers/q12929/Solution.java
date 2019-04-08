package programmers.q12929;

import java.math.BigInteger;

public class Solution {
    public int solution(int n) {
        int answer;

        answer = (combination(n, n).subtract(combination(n ,n+1))).intValue();  //카탈란수 참고

        return answer;
    }

    public BigInteger combination(int i, int count) {
        BigInteger big = BigInteger.ONE;
        int num = 2*i;
        for (int j = 0; j < count; j++) {
            long number = num--;
            big = big.multiply(BigInteger.valueOf(number));
        }

        return big.divide(BigInteger.valueOf(factorial(count)));
    }

    public long factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n -1);
    }

}
