package programmers.school.week1;


import org.junit.Test;

import java.util.*;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        int quotient = n;
        long oneCount;
        long newOneCount = 0;
        List<Integer> oneCounts = new ArrayList<>();

        oneCounts = binaryNumber(quotient, oneCounts);
        oneCount = countOne(oneCounts);

        oneCounts.clear();

        while (oneCount != newOneCount) {
            answer = ++n;
            List<Integer> list = binaryNumber(answer, oneCounts);
            newOneCount = countOne(list);
            list.clear();
        }

        return answer;
    }

    public List<Integer> binaryNumber(int quotient, List<Integer> oneCounts) {
        while (quotient != 1) {
            oneCounts.add(quotient % 2);
            quotient = quotient / 2;
        }
        return oneCounts;
    }

    private long countOne(List<Integer> oneCounts) {
        return oneCounts.stream().filter(i -> i == 1).count() + 1;
    }


    @Test
    public void test() {
        assertThat(solution(5)).isEqualTo(5);
    }
}
