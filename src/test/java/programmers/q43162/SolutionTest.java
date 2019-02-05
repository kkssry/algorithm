package programmers.q43162;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void name() {
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        Network network = new Network();
        System.out.println(network.solution(computers.length, computers));

    }
}