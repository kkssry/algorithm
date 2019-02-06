package programmers.q42746;

import org.junit.Test;

import java.util.*;

public class SolutionTest {
    @Test
    public void 자릿수구하기() {
        int length = (int)(Math.log10(999)+1);
        System.out.println(length);
    }

    @Test
    public void 숫자를문자열로() {
        int num = 12345;
        String numStr = num + "";   //숫자 + "" = 문자
        String a = numStr + 1;      //문자 + 1 = 문자
        System.out.println(numStr.compareTo(a));
    }

    @Test
    public void 문자열비교() {
        String[] str = {"2", "10", "6"};
        List<String> list = new ArrayList<String>(Arrays.asList(str));
        Collections.sort(list, (o1, o2) -> (o2+o1).compareTo(o1+o2));
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String num1, String num2) {
//                return (num2 + num1).compareTo(num1 + num2);
//            }
//        });
        System.out.println(list);
    }

    @Test
    public void resultCall() {
        int[] numbers = {6, 10, 2};
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers));
    }
}
