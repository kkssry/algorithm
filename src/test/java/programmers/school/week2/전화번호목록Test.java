package programmers.school.week2;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class 전화번호목록Test {
    @Test
    public void mainTest() {
        전화번호목록 sol = new 전화번호목록();
        String[] phonelist = {"119", "97674223", "1195524421"};
        String[] phonelist2 = {"123","456","789"};
        String[] phonelist3 = {"12","123","1235","567","88"};
        assertThat(sol.solution(phonelist)).isFalse();
        assertThat(sol.solution(phonelist2)).isTrue();
        assertThat(sol.solution(phonelist3)).isFalse();
    }

    @Test
    public void 문자열시작테스트() {
        String a = "abcde";
        String b = "ab";

        System.out.println(a.startsWith(b));
    }
}