package programmers.school.week3;


import org.junit.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 더맵게Test {
    @Test
    public void mainTest() {
        더맵게 sol = new 더맵게();
        int[] scovile = {1,1,1,1,1};
        assertThat(sol.solution(scovile,100)).isEqualTo(2);
    }

    @Test
    public void 우선순위큐테스트() {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        pr.add(1);
        pr.add(1);
        pr.add(1);
        pr.add(1);
        pr.add(1);
        for (int i = pr.size()-1; i >=0 ; i--) {
            System.out.println(pr.poll());
        }

//        callFunc(pr);
//        System.out.println(pr);


    }

    private void callFunc(PriorityQueue<Integer> pr) {
        System.out.println(pr.poll());
    }
}