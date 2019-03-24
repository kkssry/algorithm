package programmers.q12935;

import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};

        Integer[] numberBox = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        List<Integer> numbers = new ArrayList<>(Arrays.asList(numberBox));

        Collections.sort(numbers, (o1, o2) -> o2 - o1);

        numbers.remove(numbers.get(numbers.size() - 1));
        if (numbers.isEmpty()) {
            return new int[]{-1};
        }

        answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }
}
