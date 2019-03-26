package programmers.school.week2;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class 기능개발Test {
    @Test
    public void maintTest() {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        기능개발 sol = new 기능개발();
        assertThat(sol.solution(progresses,speeds)).containsExactly(2,1);

    }

    @Test
    public void queueTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.peek();
        ((LinkedList<Integer>) queue).set(0,100);

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(19);
        list.add(0);
        list.add(2);
        list.add(0);
        list.add(0);
        list.add(2);
        list.add(2);

        System.out.println(list);

        list.removeAll(Arrays.asList(0,2));
        System.out.println(list);

    }
}