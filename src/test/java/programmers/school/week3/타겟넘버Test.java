package programmers.school.week3;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 타겟넘버Test {
    @Test
    public void Test() {
        타겟넘버 sol = new 타겟넘버();
        int[] numbers = {1,1,1,1};
        assertThat(sol.solution(numbers,2)).isEqualTo(5);
    }

    @Test
    public void 인트매개변수() {
        int a = 3;
        callFunc(a);
        System.out.println(a);
    }

    private void callFunc(int a) {
        a = 4;
    }

    @Test
    public void set테스트() {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,4,3));

        Collections.sort(list2);
        set.add(list);
        set.add(list2);

        System.out.println(set.size());
    }

    @Test
    public void test() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("i : " + i);
            callFor(i);
        }
    }

    private void callFor(int i) {
        for (int j = 0; j <= i; j++) {
            System.out.println("j :" + j);
            if (j ==3) {
                System.out.println("--------------");
                return;
            }

        }
    }
}