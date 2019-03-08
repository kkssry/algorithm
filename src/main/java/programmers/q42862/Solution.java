package programmers.q42862;

import java.util.*;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n];
        for (int i = 0; i < clothes.length; i++) {
            clothes[i] = 1;
        }

        System.out.println("init array : " + Arrays.toString(clothes));

        int answer = 0;
        List<Integer> losts = new ArrayList<>();
        List<Integer> reverses = new ArrayList<>();

        for (int i = 0; i < lost.length; i++) {
            losts.add(lost[i]);
        }

        for (int i = 0; i < reserve.length; i++) {
            reverses.add(reserve[i]);
        }
        for (int i = 0; i < reverses.size(); i++) {
            clothes[reverses.get(i) - 1] = 2;
        }

        for (int i = 0; i < losts.size(); i++) {
            clothes[losts.get(i) - 1]--;
        }


        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] == 0 && i == 0) {
                if (clothes[i + 1] == 2) {
                    clothes[i] = 1;
                    clothes[i + 1] = 1;
                }
            }

            if (clothes[i] == 0 && i > 0) {
                if (clothes[i - 1] == 2) {
                    clothes[i] = 1;
                    clothes[i - 1] = 1;
                }

                System.out.println(i);

                if (i+1 < clothes.length) {
                    if (clothes[i + 1] == 2) {
                        clothes[i] = 1;
                        clothes[i + 1] = 1;
                    }
                }
            }

            if (clothes[i] == 0 && i == clothes.length - 1) {
                if (clothes[i - 1] == 2) {
                    clothes[i] = 1;
                    clothes[i - 1] = 1;
                }
            }
        }

        for (int j = 0; j < clothes.length; j++) {
            if (clothes[j] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
