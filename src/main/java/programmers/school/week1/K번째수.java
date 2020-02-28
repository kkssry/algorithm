package programmers.school.week1;


import org.junit.Test;

import java.util.*;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            System.out.println(list);
            answer[i] = list.get(commands[i][2] - 1);
        }

        return answer;
    }

    @Test
    public void test() {
        int[] array = {4, 5, 7, 23, 9, 3, 3, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] arr = {7, 3, 3};
        assertThat(solution(array, commands)).isEqualTo(arr);
    }
}
