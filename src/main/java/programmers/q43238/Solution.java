package programmers.q43238;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        TreeSet<Integer> checkTimes = new TreeSet<>();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            persons.add(new Person());
        }

        for (int i = 0; i < times.length; i++) {
            checkTimes.add(times[i]);
        }

        for (int i = 0; i < checkTimes.size(); i++) {

        }

        for (int i = 0; i < checkTimes.size(); i++) {

        }

        return answer;
    }

    class Person{
        int gage;

        public Person(int gage) {
            this.gage = gage;
        }

        public Person() {
        }
    }
}
