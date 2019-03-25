package programmers.q42860;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        assertThat(sol.solution("JEROEN")).isEqualTo(23);
    }

    @Test
    public void 문자열비고() {
        char n = 'N';
        char z = 'Z';
        char a = 'A';
        char o = 'O';

//        String arr = "abcdefg";
//        char[] arr2 = arr.toCharArray();
//        for (int i = 0; i < arr.length(); i++) {
//            System.out.println(arr2[i]);
//        }

        System.out.println(n-a);
        System.out.println(z-n);
        System.out.println(z-z);
    }

    @Test
    public void 나누기테스트() {
        List<Word> list = new ArrayList<>();
        list.add(new Word("a"));
        list.add(new Word("b"));
        list.add(new Word("c"));
        list.get(0).isA = true;
        System.out.println(changeElement(list));
    }

    class Word{
        String name;
        boolean isA;

        public Word(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "name='" + name + '\'' +
                    ", isA=" + isA +
                    '}';
        }
    }

    private List<Word> changeElement(List<Word> list) {
        if (list.get(0).equals("a")) {
            list.get(0).isA = true;
        }
        return list;
    }
}