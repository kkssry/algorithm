package programmers.q43164;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        String[][] arr = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] arr2 = {{"ICN", "SFO"}, {"ICN", "ATL"},
                           {"SFO", "ATL"},{"ATL", "ICN"},
                           {"ATL", "SFO"}};
        String[] a = {"ICN","JFK","HND","IAD"};
        String[] b = {"ICN", "ATL","ICN","SFO","ATL","SFO"};
        assertThat(sol.solution(arr2)).isEqualTo(b);
    }

    @Test
    public void 배열테스트() {
        int[] a = new int[1];
        int b = 9;
        callFunc(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(b);
    }

    private void callFunc(int[] a, int b) {
        a[0] = 100;
        b = 1000;
    }

    @Test
    public void 배열을담고있는리스트정렬테스트() {
        List<String[]> list = new ArrayList<>();
        String[] arr1 = {"ab","ac","ad","ae","az"};
        String[] arr2 = {"ab","ac","ad","aa","az"};
        list.add(arr1);
        list.add(arr2);
        System.out.println(list);

        Collections.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                for (int i = 0; i < o1.length; i++) {
                    for (int j = 0; j < o1[i].length(); j++) {
                        if (o1[i].charAt(j) > o2[i].charAt(j)) {
                            return 1;
                        }
                        if (o1[i].charAt(j) < o2[i].charAt(j)) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });

        System.out.println(list);
    }
}