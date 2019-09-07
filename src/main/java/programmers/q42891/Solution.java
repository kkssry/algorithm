package programmers.q42891;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[] food_times, long k) {
        Food[] foods = new Food[food_times.length];
        initFoods(foods, food_times);
        Arrays.sort(foods);
        return startMukbang(foods, k);
    }

    private int startMukbang(Food[] foods, long k) {
        long pre = 0;
        for (int i = 0; i < foods.length; i++) {
            long sum = (foods[i].amount - pre) * (foods.length - i);
            pre = foods[i].amount;
             if (sum <= k) {
                k -= sum;
            } else {
                Food[] copyFoods = Arrays.copyOfRange(foods, i, foods.length);
                Arrays.sort(copyFoods, Comparator.comparingInt(o -> o.order));
                return copyFoods[(int) k % copyFoods.length].order;
            }
        }
        return -1;
    }

    private void initFoods(Food[] foods, int[] food_times) {
        for (int i = 0; i < food_times.length; i++) {
            foods[i] = new Food(i + 1, food_times[i]);
        }
    }

    static class Food implements Comparable<Food> {
        int order;
        int amount;

        Food(int order, int time) {
            this.order = order;
            this.amount = time;
        }

        @Override
        public int compareTo(Food o) {
            if (amount == o.amount) {
                return Integer.compare(order, o.order);
            }
            return Integer.compare(amount, o.amount);
        }

        @Override
        public String toString() {
            return "Food{" +
                    "order=" + order +
                    ", amount=" + amount +
                    '}';
        }
    }
}
