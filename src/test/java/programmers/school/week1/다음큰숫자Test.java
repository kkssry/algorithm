package programmers.school.week1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class 다음큰숫자Test {
    @Test
    public void mainTest() {
        다음큰숫자 sol = new 다음큰숫자();
        int n = 15;
        System.out.println(sol.solution(n));
    }

    @Test
    public void methodTest() {
        다음큰숫자 sol = new 다음큰숫자();
        List<Integer> list = new ArrayList<>();
        System.out.println(sol.binaryNumber(78,list));
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);

        long count = list.stream().filter(i->i==1).count();
        System.out.println(count);
    }

    @Test
    public void 매개변수값테스트() {
        System.out.println(test(5));
    }

    public int test(int n) {
        while(n!=8) {
            n = ++n;
        }
        return n;
    }
}