package programmers.school.week2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class 다리를지나는트럭Test {
    @Test
    public void mainTest() {
        int[] truck_weights = {7,4,5,6};
        다리를지나는트럭 sol = new 다리를지나는트럭();
        assertThat(sol.solution(2,10,truck_weights)).isEqualTo(8);
    }

    @Test
    public void queueTest() {
       List<Car> list = new ArrayList<>();
        list.add(new Car(10));
        list.add(new Car(20));
        list.add(new Car(30));

        int a = list.stream().mapToInt(i->i.weight).sum();
        System.out.println(a);


        System.out.println(list.stream().map(i-> i.weight + 1).collect(Collectors.toList()));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).weight);
        }
    }

    class Car{
        int weight;

        public Car(int weight) {
            this.weight = weight;
        }
    }
}