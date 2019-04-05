package programmers.school.week3;

import java.util.*;

public class 타겟넘버 {
    Set<List<Number>> set = new HashSet<>();
    public int solution(int[] numbers, int target) {
        int answer = 0;

        List<Number> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {      // numbers객체를 관리하는 리스트 생성
            list.add(new Number(numbers[i], false));
        }

        findTarget(list, target);
        answer = set.size();

        return answer;
    }

    private void findTarget(List<Number> list, int target) {
        for (int i = 0; i < list.size(); i++) {         // '-' 의 개수
            substractCount(i, list, target,0);
            System.out.println(i);
        }
    }

    private void substractCount(int i, List<Number> list, int target,int depth) {
        if (list.stream().filter(n -> n.isSubstract).count() == i) {
            if (list.stream().mapToInt(j->j.value).sum() == target) {
                set.add(list);
                System.out.println(set);
            }
            return;
        }

        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).isSubstract) {
                continue;
            }
            if (!list.get(k).isSubstract) {
                list.get(k).isSubstract = true;
                list.get(k).value *= -1;
            }

            substractCount(i, list, target,depth+1);
            list.get(k).isSubstract = false;
            list.get(k).value *= -1;
        }
    }

    class Number {
        int value;
        boolean isSubstract;

        public Number(int value, boolean isSubstract) {
            this.value = value;
            this.isSubstract = isSubstract;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "isSubstract=" + isSubstract +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Number)) return false;
            Number number = (Number) o;
            return value == number.value &&
                    isSubstract == number.isSubstract;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, isSubstract);
        }
    }
}
