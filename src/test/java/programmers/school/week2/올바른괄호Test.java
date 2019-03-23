package programmers.school.week2;


import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 올바른괄호Test {
    @Test
    public void mainTest() {
        올바른괄호 sol = new 올바른괄호();
        assertThat(sol.solution("()()")).isTrue();
        assertThat(sol.solution("(())()")).isTrue();
        assertThat(sol.solution(")()(")).isFalse();
        assertThat(sol.solution("(()(")).isFalse();
    }

    @Test
    public void 스택사이즈() {
        Stack<String> stack = new Stack<>();
        stack.add("(");
        stack.pop();

        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
    }
}