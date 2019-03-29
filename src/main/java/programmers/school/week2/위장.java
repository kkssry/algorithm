package programmers.school.week2;

import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer;
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> clothesOf = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (clothesOf.containsKey(clothes[i][1])) {
                clothesOf.put(clothes[i][1], clothesOf.get(clothes[i][1]) + 1);
                continue;
            }
            clothesOf.put(clothes[i][1], 1);
        }

        System.out.println(clothesOf);


        Set<String> keys = clothesOf.keySet();
        for (String key : keys) {
            list.add(clothesOf.get(key));
        }

        answer = list.stream().map(i -> i + 1).reduce(1, (i, j) -> i * j);

        return answer - 1;
    }
}
