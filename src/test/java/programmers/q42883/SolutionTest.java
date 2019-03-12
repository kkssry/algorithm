package programmers.q42883;

import org.junit.Test;

import java.util.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        String number = "4177252841";
        int k = 4;
        Solution sol = new Solution();
        System.out.println(sol.solution(number, k));
    }

    @Test
    public void name() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(1);
        queue.add(7);
        queue.add(7);
        queue.add(2);
        queue.add(5);
        queue.add(2);
        queue.add(8);
        queue.add(4);
        queue.add(1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue);
    }

    @Test
    public void 문자열과인트조합() {
        List<Integer> list = Arrays.asList(4,5,6,7);
        String arr = "";
        for (int i = 0; i < list.size(); i++) {
            arr += list.get(i);
        }

        list.forEach(System.out::println);

        System.out.println(arr);
        System.out.println(arr.getClass());
    }

    @Test
    public void 문자열을스트링버퍼로() {
        String a = "9876";

        StringBuffer sb = new StringBuffer(a);
        System.out.println(sb.charAt(0) > sb.charAt(1));
        sb.deleteCharAt(0);
        System.out.println(sb.toString());
    }

    @Test
    public void substringCut() {
        StringBuilder sb = new StringBuilder("989999999976");
        System.out.println(sb.substring(0,sb.length()-2));
    }

    @Test
    public void setTest() {
        Set<String> asdf = new HashSet<>();
        String b;
        asdf.add("1");
        asdf.add("2");
        asdf.add("1");
        asdf.add("3");
        Iterator<String> as = asdf.iterator();
//        while(as.hasNext()) {
//            asdf.
//        }

        System.out.println(asdf);
    }
}