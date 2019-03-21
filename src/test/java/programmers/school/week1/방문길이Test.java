package programmers.school.week1;


import org.junit.Test;


import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 방문길이Test {
    방문길이 sol = new 방문길이();

    @Test
    public void mainTest() {
        assertThat(sol.solution("LULLLLLLU")).isEqualTo(7);
//


//        assertThat(sol.solution("ULURRDLLU")).isEqualTo(7);
//        assertThat(sol.solution("LULLLLLLU")).isEqualTo(7);
    }

    @Test
    public void 객체같으면Set에담는거테스트() {
//        Set<Number> set = new HashSet<>();
//        set.add(new Number(1));
//        set.add(new Number(1));
//        System.out.println(set.size());
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1","2");
    }

    class Number{
        int num;

        public Number(int num) {
            this.num = num;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Number number = (Number) o;
//            return num == number.num;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(num);
//        }
    }

    @Test
    public void name1() {
        방문길이 sol = new 방문길이();

        방문길이.Line l1 = sol.new Line(sol.new Point(0,0), sol.new Point(0,1));
        방문길이.Line l2 = sol.new Line(sol.new Point(0,1), sol.new Point(0,0));

        l1.sortPoint();
        l2.sortPoint();

        List<방문길이.Line> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
//        Collections.sort(list);
        System.out.println(list);

//        System.out.println(l1.hashCode());
//        System.out.println(l2.hashCode());
//
//        Set<방문길이.Line> set = new HashSet<>();
//        set.add(l1);
//        set.add(l2);
//
//        for (방문길이.Line line : set) {
//            System.out.println(line.toString());
//        }
//        System.out.println(set.size());
//        System.out.println(l1.equals(l2));
    }
}