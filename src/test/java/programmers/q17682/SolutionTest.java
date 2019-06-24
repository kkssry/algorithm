package programmers.q17682;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void splitTest() {
        String a = "aa1aa2a23";
        String[] arr = a.split("a");
        List<Integer> scores = new ArrayList<>();
        for (String s : arr) {
            try {
                scores.add(Integer.parseInt(s));
            } catch (NumberFormatException ignored) { }
        }
        System.out.println(scores);
    }

    @Test
    public void 문자를특정문자로바꿈() {
        String a = "JEA4SD4A10";
        for (int i = 0; i < a.length(); i++) {
            try {
                Integer.parseInt(a.charAt(i) + "");
            }catch (NumberFormatException e) {
                a = a.replace(a.charAt(i),'a');
            }
        }
        System.out.println(a);
    }

    @Test
    public void solutionTest() {
        Solution sol = new Solution();
//        System.out.println(sol.solution("1S2D*3T"));
//        System.out.println(sol.solution("1D2S#10S"));
//        System.out.println(sol.solution("1D2S0T"));
//        System.out.println(sol.solution("1S*2T*3S"));
//        System.out.println(sol.solution("1D#2S*3S"));
//        System.out.println(sol.solution("1T2D3D#"));
        System.out.println(sol.solution("1D2S3T*"));


    }
}