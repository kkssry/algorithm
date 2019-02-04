package programmers;

import java.util.HashSet;
import java.util.Set;

public class q43165 {
    int result = 0;
    int finalResult = 0;

    public int solution(int[] numbers, int target) {
        int[] flag = new int[numbers.length];
        result = target;
        recursive(numbers, flag, 0);
        return finalResult;
    }

    private void recursive(int[] numbers, int[] flag, int n) {
        if (n == numbers.length) {
            printData(numbers, flag);
            return;
        }

        flag[n] = 1;
        recursive(numbers, flag, n + 1);

        flag[n] = -1;
        recursive(numbers, flag, n + 1);
    }

    private void printData(int[] numbers, int[] flag) {
        int result2 = 0;
        for (int i = 0; i < flag.length; i++) {
            result2 += numbers[i] * flag[i];
        }
        if (result2 == result) {
            finalResult++;
        }
    }

}
