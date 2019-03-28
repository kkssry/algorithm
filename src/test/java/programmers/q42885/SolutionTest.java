package programmers.q42885;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] people = {70,50,80,50};
        assertThat(sol.solution(people,100)).isEqualTo(5);
    }

    @Test
    public void mainPerson() {
//        List<Solution.Person> list = new ArrayList<>();
//        list.add(new Solution.Person(40));
//        list.add(new Solution.Person(40));
//        list.add(new Solution.Person(30));
//        list.add(new Solution.Person(30));
//        list.add(new Solution.Person(30));
//
//        Collections.sort(list);

//        System.out.println(list);

    }
}