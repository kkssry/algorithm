package programmers.q12929;

import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class SolutionTest {

    @Test
    public void name() {
        Solution sol = new Solution();
        assertThat(sol.solution(5)).isEqualTo(42);
        assertThat(sol.solution(6)).isEqualTo(132);
        assertThat(sol.solution(7)).isEqualTo(429);
        assertThat(sol.solution(8)).isEqualTo(1430);
        assertThat(sol.solution(9)).isEqualTo(4862);
        assertThat(sol.solution(10)).isEqualTo(16796);
        assertThat(sol.solution(11)).isEqualTo(58786);
        assertThat(sol.solution(12)).isEqualTo(208012);
        assertThat(sol.solution(13)).isEqualTo(742900);
        assertThat(sol.solution(14)).isEqualTo(2674440);
    }

    @Test
    public void 팩토리얼테스트() {
        Solution sol = new Solution();
//        System.out.println(sol.combination(3,2));
        System.out.println(sol.factorial(15));
    }

    @Test
    public void bigIntegerTest() {
        BigInteger big = BigInteger.ONE;
        big.multiply(BigInteger.valueOf(1));
        big.multiply(BigInteger.valueOf(100));

        System.out.println(big.intValue());
    }
}