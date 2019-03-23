package programmers.school.week2;

import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<Car> crossingcars = new LinkedList<>();
        List<Car> bridge = new ArrayList<>();
        List<Car> completeCars = new ArrayList<>();
        Car car = null;

        for (int i = 0; i < truck_weights.length; i++) {
            crossingcars.add(new Car(1, truck_weights[i]));
        }

        while (completeCars.size() != truck_weights.length) {
            answer++;
            for (int i = 0; i < bridge.size(); i++) {
                bridge.get(i).length++;
            }

            for (int i = 0; i < bridge.size(); i++) {
                if (bridge_length < bridge.get(i).length) {
                    completeCars.add(bridge.remove(i));
                }
            }

            if (!crossingcars.isEmpty()) {
                car = crossingcars.poll();
                bridge.add(car);
            }

            if (weight < bridge.stream().mapToInt(i -> i.weight).sum()) {
                crossingcars.addFirst(bridge.remove(bridge.size()-1));
            }

            for (int i = 0; i < bridge.size(); i++) {
                if (bridge_length < bridge.get(i).length) {
                    completeCars.add(bridge.remove(i));
                }
            }
        }

        return answer;
    }

    class Car {
        int length;
        int weight;

        public Car(int length, int weight) {
            this.length = length;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "length=" + length +
                    ", weight=" + weight +
                    '}';
        }
    }
}
