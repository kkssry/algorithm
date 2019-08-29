package baekjoon.permutation_practice;

import java.util.Arrays;

/*
        int[] arr = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    System.out.println(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        다음과 같은 배열에서 숫자 3개의 조합을 구하는 과정에서
        순차적으로 돌면서 조합을 구하려면 반복문이 n개 만큼 필요하다.
        구해야할 숫자 n개의 조합을 구하는데, 이 소스에서 힌트를 얻어 구현했다.
 */


public class Main {
    public static void main(String[] args) {
        int[] totalArray = {1, 2, 3, 4, 5, 6, 7};
        int combinationElementCount = 3;
        int[] combinationStartIndexes = new int[combinationElementCount];
        initCombinationStartIndexes(combinationStartIndexes, totalArray.length);
        int startIndex = 0;
        int eachDigitIndex = 0;
        int[] resultContainer = new int[combinationElementCount];
        combinationStart(totalArray, combinationStartIndexes, eachDigitIndex, startIndex, resultContainer);
    }

    private static void initCombinationStartIndexes(int[] arr2, int length) {
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (length - 1) - (arr2.length - i) + 1;
        }
    }

    private static void combinationStart(int[] arr, int[] arr2, int numberSt, int startIndex, int[] resultContainer) {
        if (numberSt == arr2.length) {
            System.out.println(Arrays.toString(resultContainer));
            return;
        }

        for (int i = startIndex; i <= arr2[numberSt]; i++) {
            resultContainer[numberSt] = arr[i];
            combinationStart(arr, arr2, numberSt + 1, i + 1, resultContainer);
        }

    }

}
