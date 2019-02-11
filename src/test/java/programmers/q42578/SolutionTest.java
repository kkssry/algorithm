package programmers.q42578;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void name() {
        String[][] a = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
        Solution solution = new Solution();
        System.out.println(solution.solution(a));
    }

    @Test
    public void 해시맵() {
        Map<String,String> map = new HashMap<>();
        map.put("a","b");
        map.put("b","c");
        map.put("c","d");
        map.put("a","abcdefg");

        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
    }

    @Test
    public void ss() {
        int a = 0;
        String[][] b = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
        for (String[] strings : b) {
            for (String string : strings) {
                a++;
                if (a%2 ==0)
                    System.out.println(string);
            }
        }
    }

    @Test
    public void 문자열출력() {
        String a = "asdf";
        System.out.println(a);
    }

    @Test
    public void asdf() {
        Map<String,Integer> map = new HashMap<>();
        int one = 1;
        map.put("headgear",1);
        if (map.containsKey("headgear")) {
            map.put("headgear", map.get("headgear")+1);
        }
        System.out.println(map.get("headgear"));
    }

    @Test
    public void mapKeySetTest() {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        System.out.println(map.entrySet());
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(map.get(s));
        }
    }

    @Test
    public void wefasd() {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
    }

    @Test
    public void 리스트속성곱하기() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int sum = list.stream().reduce(1,(a,b)->a*b);
        System.out.println(list);
        System.out.println(sum);
    }
}