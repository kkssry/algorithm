package programmers.q43164;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        String[][] arr = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String[][] arr2 = {
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL", "SFO"}, {"ATL", "ICN"}
        };

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
        String[] arr2 = {"ab","ac","ad","ab","az"};
        String[] arr3 = {"ab","ac","ad","ae","aa"};
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
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

    @Test
    public void 배열특정문자는맨앞() {
        List<String> listString  = new ArrayList<String>();
        listString.add("general");
        listString.add("faq");
        listString.add("contact");
        listString.add("a");
        listString.add("b");

        Collections.sort(listString, new Comparator<String>() {
            @Override
            public int  compare(String o1, String o2) {
                if (o1.equals(o2)) // update to make it stable
                    return 0;
                if (o1.equals("general"))
                    return -1;
                if (o2.equals("general"))
                    return 1;
                return o1.compareTo(o2);
            }
        });

        System.out.println(listString);
    }

    @Test
    public void 리스트배열() {
        List<String> list = new ArrayList<>();
        list.add("ICN");
        list.add("ATL");
        list.add("SFO");
        list.add("ATL");
        list.add("ICN");
        list.add("SFO");


    }
}