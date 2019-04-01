package programmers.practice;


import org.junit.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PracticeTest {

    @Test
    public void mainTest() {
        TreeMap<Integer,String> tree = new TreeMap<>();
        tree.put(300,"c");
        tree.put(200,"b");
        tree.put(1000,"z");
        tree.put(1000,"a");

        System.out.println(tree);
    }
}