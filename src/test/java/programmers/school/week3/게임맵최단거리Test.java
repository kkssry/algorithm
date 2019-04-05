package programmers.school.week3;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 게임맵최단거리Test {
    @Test
    public void Test() {
        게임맵최단거리 sol = new 게임맵최단거리();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        assertThat(sol.solution(maps)).isEqualTo(11);
    }
}