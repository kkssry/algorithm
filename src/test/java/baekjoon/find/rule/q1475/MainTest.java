package baekjoon.find.rule.q1475;

import org.junit.Test;

import java.util.Arrays;


public class MainTest {
    @Test
    public void mapTest() {

        String[] arr = {"a","b","c"};
        String arr2 = "d";

        callFunc(arr);
        callFunc(arr2);

    }



    // 가변 인자는 타입은 지정해주고 개수는 가변적으로 받을 수 있다.
    // (가변인자는 배열처럼 직접 출력하면 주소를 출력한다.)
    private void callFunc(String... o) {
        System.out.println(o);
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(o));
        System.out.println("-----------------------------");

        for (String s : o) {
            System.out.println(s);
        }
        System.out.println("-----------------------------");
    }
}