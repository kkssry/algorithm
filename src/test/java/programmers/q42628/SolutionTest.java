package programmers.q42628;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        String[] arr = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        assertThat(sol.solution(arr)).containsExactly(333,-45);
    }

    @Test
    public void 파싱에러() {
        String a = "D -1";
        System.out.println(a.startsWith("D "));
        System.out.println(a.startsWith("D -"));
    }

    @Test
    public void 파싱비교() {
//        String a = "a,sdf";
//        System.out.println(Arrays.toString(a.split("]")));
//
//        System.out.println(a.equals(a.split("]")[0]));

        String as = "I 16";
        List<String> list = new ArrayList<>();
        list.add(as.split("I ")[1]);
        System.out.println(list);

        String[] arr = as.split("I ");
        System.out.println(arr[1]);
        System.out.println(Arrays.toString(as.split("I ")));
    }

    @Test
    public void 우선순위큐테스트() {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        pr.add(2);
        pr.add(9);
        pr.add(1);
        pr.add(5);
        pr.add(4);
        System.out.println(pr);

        System.out.println(pr.poll());
    }

    @Test
    public void 시작값() {
        String a = "I 1";
        String b = "D 1";
        String c = "D-1";

        System.out.println(a.startsWith("I "));
        System.out.println(b.startsWith("D "));
        System.out.println(c.startsWith("D "));
    }
}
