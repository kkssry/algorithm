package baekjoon.q1138;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        int[] person = new int[N];
        for (int i = 0; i < N; i++) {
            person[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(person));
        new Solution().solution(person);
    }
}

class Solution {
    public void solution(int[] person) {
        List<Integer> result = new ArrayList<>();
        for (int i = person.length - 1; i >= 0; i--) {
            result.add(person[i], i + 1);
        }

        System.out.println(result);

        for (Integer no : result) {
            System.out.print(no + " ");
        }
    }
}