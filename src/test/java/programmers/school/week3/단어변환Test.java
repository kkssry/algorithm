package programmers.school.week3;


import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 단어변환Test {
    @Test
    public void mainTest() {
        단어변환 sol = new 단어변환();
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        assertThat(sol.solution("hit","cog",arr)).isEqualTo(4);
    }

    @Test
    public void 글자수맞추기테스트() {
        String a = "asdf";
        String b = "acdf";
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] == d[i])
//        }
//        Stream.of(a).map(i->i.c)
        System.out.println(a.contains("asde"));
    }
}