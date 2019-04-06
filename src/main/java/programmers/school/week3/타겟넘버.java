package programmers.school.week3;

import java.util.*;

public class 타겟넘버 {
    int result = 0;
    int finalResult = 0;

    public int solution(int[] numbers, int target) {
        int answer;
        int[] flag = new int[numbers.length];
        result = target;
        recursive(numbers,flag,0);
        answer =finalResult;
        return answer;
    }

    private void recursive(int[] numbers, int[] flag, int i) {
        if (i == numbers.length) {
            printData(numbers,flag);
            return;
        }

        flag[i] = 1;
        recursive(numbers,flag,i+1);

        flag[i] = -1;
        recursive(numbers,flag, i+1);
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
