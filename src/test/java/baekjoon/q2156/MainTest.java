package baekjoon.q2156;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void multipleArrays() {

        Number[][] num = new Number[2][];

        num[0] = new Number[]{new Number(3)};
        num[1] = new Number[]{new Number(4), new Number(5), new Number(6)};

        System.out.println(Arrays.deepToString(num));

    }

    class Number{
        int value;

        public Number(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    '}';
        }
    }
}