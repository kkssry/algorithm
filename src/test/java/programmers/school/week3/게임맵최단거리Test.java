package programmers.school.week3;


import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 게임맵최단거리Test {
    @Test
    public void test() {
        게임맵최단거리 sol = new 게임맵최단거리();
        int[][] maps = {{1,1,1,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,1},
                        {1,1,1,1,1}};
        assertThat(sol.solution(maps)).isEqualTo(11);
    }

    @Test
    public void treeSet테스트() {
        Set<Integer> set = new TreeSet<>();
        set.add(4);
        set.add(9);
        set.add(2);
        set.add(100);
        set.add(1);

        System.out.println(set.iterator().next());

        boolean[][] bol = new boolean[3][2];
    }
}