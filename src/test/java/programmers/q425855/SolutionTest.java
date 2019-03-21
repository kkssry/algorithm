package programmers.q425855;

import org.junit.Test;
import programmers.q42585.Solution;

import java.util.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        String input = "()(((()())(())()))(())";
        Solution sol = new Solution();
        System.out.println(sol.solution(input));
    }

    @Test
    public void 스택테스트() {
        Stack<String> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);
    }
}
