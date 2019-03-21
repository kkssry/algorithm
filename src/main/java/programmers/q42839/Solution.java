package programmers.q42839;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(String numbers) {
        Set<String> combNum = new HashSet<>();
        Set<String> finalNum = new HashSet<>();
        int depth = 0;
        int answer;

        String[] numberElements = numbers.split("");

        permutation(numberElements, depth, combNum);

        for (int i = 0; i < numbers.length(); i++) {
            for (String s : combNum) {
                finalNum.add(s.substring(0, i + 1));
            }
        }

        answer = countPrimeNum(finalNum);
        return answer;
    }

    private int countPrimeNum(Set<String> combNum) {
        int answer = 0;
        Set<Integer> finalNum = combNum.stream().map(Integer::parseInt).filter(i -> i >= 2).collect(Collectors.toSet());
        System.out.println(finalNum);

        loop:for (Integer integer : finalNum) {
            if (integer >= 3) {
                for (int j = 2; j <= Math.sqrt(integer); j++) {
                    if (integer % j == 0 || integer < 3) {
                        continue loop;
                    }
                }
                answer++;
            }

            if (integer == 2) {
                answer++;
            }
        }
        return answer;
    }


    private void permutation(String[] numberElements, int depth, Set<String> combNum) {
        if (depth == numberElements.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numberElements.length; i++) {
                sb.append(numberElements[i]);
            }
            combNum.add(sb.toString());
            return;
        }

        for (int i = depth; i < numberElements.length; i++) {
            swap(i, depth, numberElements);
            permutation(numberElements, depth + 1, combNum);
            swap(i, depth, numberElements);
        }
    }


    private void swap(int i, int depth, String[] numberElements) {
        int temp = Integer.parseInt(numberElements[depth]);
        numberElements[depth] = numberElements[i];
        numberElements[i] = String.valueOf(temp);
    }


}
