package programmers.q17687;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void stackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    @Test
    public void solutionTest() {
        Solution sol = new Solution();
        System.out.println(sol.solution(16,16,2,1));
    }

    @Test
    public void charTest() {
        int a = 65;
        System.out.println(String.valueOf((char)a));
    }
}