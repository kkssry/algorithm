package programmers.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public int solution(int[] people, int[] tshirts) {
        Arrays.sort(people);

        Arrays.sort(tshirts);
        List<Integer> list2 =
                Arrays.stream(tshirts).boxed().collect(Collectors.toList());

        int answer = 0;
       for (int i = 0; i < people.length; i++) {
            loop: for (int j = 0; j < list2.size(); j++) {
                if (people[i] <= list2.get(j)) {
                    answer++;
                    list2.remove(j);
                    break loop;
                }
            }
        }
        return answer;
    }
}
