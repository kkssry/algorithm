package baekjoon.q2592;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] number = new int[10];
        initNumber(number, sc);
        System.out.println(IntStream.of(number).sum() / 10);
        Set<Integer> set = new TreeSet<>();
        initSet(set, number);
        List<Integer> numList = new ArrayList<>(set);
        List<Integer> countList = new ArrayList<>();
        initList(numList, number, countList);
        int max = countList.stream().mapToInt(i->i).max().getAsInt();
        int maxIndex = 0;
        for (int i = 0; i < countList.size(); i++) {
            if (max == countList.get(i)) {
                maxIndex = i;
                break;
            }
        }
        System.out.println(numList.get(maxIndex));
    }

    private static void initList(List<Integer> numList, int[] number, List<Integer> countList) {
        for (int currentNum : numList) {
            int num = 0;
            for (int i : number) {
                if (currentNum == i) {
                    num++;
                }
            }
            countList.add(num);
        }
    }

    private static void initNumber(int[] number, Scanner sc) {
        for (int i = 0; i < 10; i++) {
            number[i] = sc.nextInt();
        }
    }

    private static void initSet(Set<Integer> set, int[] number) {
        for (int i : number) {
            set.add(i);
        }
    }
}
