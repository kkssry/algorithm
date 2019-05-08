package baekjoon.sort;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 통계학Test {
    @Test
    public void mapTest() {
        Map<Integer,Integer> map = new HashMap<>();
//        map.put(1,2);
        map.putIfAbsent(1, 0);
        System.out.println(map.get(1));
    }
}