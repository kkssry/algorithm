package programmers.school.week1;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 스킬트리Test {
    @Test
    public void mainTest() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "CADQ","BD"};
        스킬트리 sol = new 스킬트리();
        assertThat(sol.solution(skill, skill_trees)).isEqualTo(2);


    }

    @Test
    public void prioirQueueTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<String> queue2 = new PriorityQueue<>();
        int[] arr = {1,2,3,9,10,12};
        String[] arr2 = {"a","b","e","c","z","q"};
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            queue2.add(arr2[i]);
        }
        System.out.println(queue);
        System.out.println(queue2);
    }

    @Test
    public void 숫자배열테스트() {
        String num1 = "1";
        String num2 = "2";

        assertThat(num1 + num2).isEqualTo("12");
    }

    @Test
    public void 리스트비교() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,3,1,2));

        System.out.println(list.equals(list2));
        List<Integer> list3 = new ArrayList<>(list2);

        Collections.sort(list2);

        System.out.println("list3" + list3);
        System.out.println(list2);

        System.out.println(list.equals(list2));
    }

    @Test
    public void 문자열리스트() {
        List<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("abcdef");
        list.add("abcde");

        assertThat(list.get(0).length()).isEqualTo(4);
        assertThat(list.get(1).length()).isEqualTo(6);
        assertThat(list.get(2).length()).isEqualTo(5);

    }

    @Test
    public void name() {
        String a = "abcde";
        a.contains("a");
    }
}