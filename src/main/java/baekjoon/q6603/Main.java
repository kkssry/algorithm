package baekjoon.q6603;

import java.io.*;
import java.util.*;

public class Main {
     private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = br.readLine()).equals("0")) {
            int[] inputNumbers = Arrays.stream(line.split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
            int[] numbers = new int[inputNumbers[0]];
            initNumbers(inputNumbers, numbers);
            int combinationCount = 6;
            int[] startIndexes = new int[combinationCount];
            String[] resultContainer = new String[combinationCount];
            initStartIndexes(startIndexes, numbers);
            int startIndex = 0;
            int numberSt = 0;
            combinationStart(numbers, startIndexes, startIndex, numberSt, resultContainer);
            bw.write("\n");
        }
        bw.flush();

    }

    private static void initNumbers(int[] inputNumbers, int[] numbers) {
        for (int i = 1; i < inputNumbers.length; i++) {
            numbers[i - 1] = inputNumbers[i];
        }
    }

    private static void combinationStart(int[] numbers, int[] startIndexes, int startIndex, int numberSt, String[] resultContainer) throws IOException {
        for (int i = startIndex; i <= startIndexes[numberSt]; i++) {
            resultContainer[numberSt] = String.valueOf(numbers[i]);
            if (numberSt < startIndexes.length - 1) {
                combinationStart(numbers, startIndexes, i + 1, numberSt + 1, resultContainer);
            }
            if (numberSt == startIndexes.length - 1) {
                bw.write(String.join(" ", resultContainer) + "\n");
            }
        }
    }

    private static void initStartIndexes(int[] startIndexes, int[] numbers) {
        for (int i = 0; i < startIndexes.length; i++) {
            startIndexes[i] = (numbers.length - 1) - (startIndexes.length - i) + 1;
        }
    }

}
