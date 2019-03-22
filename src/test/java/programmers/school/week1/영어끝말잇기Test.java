package programmers.school.week1;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 영어끝말잇기Test {
    @Test
    public void mainTest() {
        int n = 3;
        String[] arr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] arr2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] arr3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        String[] arr4 = {"a"};
        String[] arr5 = {"hello", "one", "even", "never", "rdw", "world", "draw","xx"};
        String[] arr6 = {};
        int[] result = {3,3};
        int[] result2 = {0,0};
        int[] result3 = {1,3};
        int[] result4 = {2,3};
        영어끝말잇기 sol = new 영어끝말잇기();
        assertThat(sol.solution(3,arr)).isEqualTo(result);
        assertThat(sol.solution(5,arr2)).isEqualTo(result2);
        assertThat(sol.solution(2,arr3)).isEqualTo(result3);
        assertThat(sol.solution(1,arr4)).isEqualTo(result2);
    }

    @Test
    public void 문자열처음과끝테스트() {
        String a = "abcdef";
        assertThat(a.endsWith("f")).isEqualTo(true);
        assertThat(a.endsWith("e")).isEqualTo(false);
    }

    @Test
    public void 배열중복테스트() {
        String[] arr = {"abc","edf","ghi","abc"};
        long a = Arrays.stream(arr).filter(i->i.contains("abc")).count();
        System.out.println(a);
    }

    @Test
    public void name1() {
        List<String> list1 = new ArrayList<>();
        list1.add("abcde");
        list1.add("abcdasde");
        list1.add("abcasdde");

        System.out.println(list1.contains("abcsde"));
    }
}