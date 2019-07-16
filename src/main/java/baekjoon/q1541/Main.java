package baekjoon.q1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String operationExpression = br.readLine();

        int firstMinusIndex = findFisrtMinusIndex(operationExpression);
        if (firstMinusIndex == 0) {
            System.out.println(sumNums(initPlusNums(operationExpression)));
            return;
        }

        String minusOperation = extractBehindMinusIndex(operationExpression, firstMinusIndex);
        String plusOperation = extractAheadMinusIndex(operationExpression, firstMinusIndex);

        Integer[] plusNums = initPlusNums(plusOperation);
        Integer[] minusNums = initMinusNums(minusOperation);

        System.out.println(sumNums(plusNums) - sumNums(minusNums));
    }

    private static int sumNums(Integer[] nums) {
        return Arrays.stream(nums).reduce(0, Integer::sum);
    }

    private static Integer[] initPlusNums(String plusOperation) {
        return Arrays.stream(plusOperation.split("[+]")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static String extractAheadMinusIndex(String operationExpression, int firstMinusIndex) {
        return operationExpression.substring(0, firstMinusIndex);
    }

    private static Integer[] initMinusNums(String minusOperation) {
        return Arrays.stream(minusOperation.split("[-+]")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static String extractBehindMinusIndex(String operationExpression, int firstMinusIndex) {
        return operationExpression.substring(firstMinusIndex + 1);
    }

    private static int findFisrtMinusIndex(String operationExpression) {
        int index = 0;
        for (int i = 0; i < operationExpression.length(); i++) {
            if (operationExpression.charAt(i) == '-') {
                index = i;
                break;
            }
        }
        return index;
    }
}
