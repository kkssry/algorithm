package baekjoon.q15666;

import java.util.*;

public class Main {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        int printNumberCount = sc.nextInt();
        int[] resultNumbers = new int[printNumberCount];
        int[] onlyNumber = initOnlyNumber(numberCount, sc);
        int resultIndex = 0;
        int numberIndex = 0;
        saveResult(onlyNumber, resultNumbers, numberIndex, resultIndex, printNumberCount);
        printResult();
    }

    private static int[] initOnlyNumber(int numberCount, Scanner sc) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numberCount; i++) {
            set.add(sc.nextInt());
        }
        int[] notDuplicateNums = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(notDuplicateNums);
        return notDuplicateNums;
    }

    private static void printResult() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void saveResult(int[] onlyNumber, int[] resultNumbers, int numberIndex, int resultIndex, int printNumberCount) {
        if (resultIndex == printNumberCount) {
            inputList(resultNumbers);
            return;
        }

        for (int i = numberIndex; i < onlyNumber.length; i++) {
            resultNumbers[resultIndex] = onlyNumber[i];
            saveResult(onlyNumber, resultNumbers, i, resultIndex + 1, printNumberCount);
        }
    }

    private static void inputList(int[] resultNumbers) {
        StringBuilder sb = new StringBuilder();
        for (int resultNumber : resultNumbers) {
            sb.append(resultNumber).append(" ");
        }
        list.add(sb.toString().trim());
    }
}
