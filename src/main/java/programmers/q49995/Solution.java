package programmers.q49995;

public class Solution {
    private static int answer = 0;

    public int solution(int[] cookie) {
        int first;
        int second;
        int firstIndex;
        int secondIndex;

        for (int i = 0; i < cookie.length - 1; i++) {
            firstIndex = i;
            first = cookie[firstIndex];
            secondIndex = i + 1;
            second = cookie[secondIndex];
            compare(first, second);

            while (true) {
                if (first < second) {
                    if (firstIndex > 0) {
                        firstIndex--;
                        first += cookie[firstIndex];
                    } else {
                        break;
                    }
                } else {
                    if (secondIndex < cookie.length - 1) {
                        secondIndex++;
                        second += cookie[secondIndex];
                    } else {
                        break;
                    }
                }

                compare(first, second);
            }
        }

        return answer;
    }

    private void compare(int first, int second) {
        if (first == second && answer < first) {
            answer = first;
        }
    }
}
