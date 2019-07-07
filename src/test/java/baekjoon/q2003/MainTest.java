package baekjoon.q2003;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void intScopeTest() {
        int a = 5;
        callFunc(a);
    }

    private void callFunc(int a) {

        for (int i = 0; i < 3; i++) {
            int b = a;
            System.out.println(b);
            while(b != 1) {
                b--;
            }
            System.out.println(b);
        }

    }
}