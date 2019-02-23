package programmers.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test3 {
    public int[] solution(int[] healths, int[][] items) {
        Set<Integer> answerList = new HashSet<>();
        Arrays.sort(healths);
        List<Integer> humanList =
                Arrays.stream(healths).boxed().collect(Collectors.toList());
        System.out.println(humanList);

        List<Integer> itemList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                if (j % 2 == 1) {
                    itemList.add(items[i][j]);
                }
            }
        }
        Collections.sort(itemList);
        System.out.println(itemList);

        for (int i = 0; i < humanList.size(); i++) {
            for (int j = 0; j < itemList.size(); j++) {
                int different = humanList.get(i) - itemList.get(j);
                if (different >= 100) {
                    answerList.add(j);
                }
            }
        }



        int[] answer = {};
        return answer;
    }
}
