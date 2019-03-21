package programmers.q12943;

public class Solution {
    public int solution(int num) {

        int answer = 0;
        long number = num;
        while(number != 1) {
            if (answer == 500) {
                return -1;
            }
            if (number % 2 == 0) {
                number /= 2;
                answer++;
            } else {
                number *= 3;
                System.out.println("num : " + number);
                number += 1;
                answer++;
            }
        }
        return answer;
    }
}
