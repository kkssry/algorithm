package baekjoon.q4344;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MainTest {
    @Test
    public void spliTest() {
        String a = "5 4 3 2 1";
        System.out.println(Arrays.toString(a.split(" ",2)));
        System.out.println(Arrays.toString(a.split(" ",2)[1].split(" ")));
//        assertThat(1).isEqualTo(2);
    }

    @Test
    public void inputTest() throws IOException {
        System.out.println("a");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
            System.out.println(br.readLine());
        }
    }
}