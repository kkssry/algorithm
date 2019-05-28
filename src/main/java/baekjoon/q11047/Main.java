package baekjoon.q11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] kindOfCoin = new int[inputs[0]];
        for (int i = 0; i < kindOfCoin.length; i++) {
            kindOfCoin[i] = Integer.parseInt(br.readLine());
        }

        fillUpMoney(kindOfCoin, inputs[1]);

    }

    private static void fillUpMoney(int[] kindOfCoin, int input) {
        int resultValue = 0;
        for (int i = kindOfCoin.length - 1; i >=0 ; i--) {
            if (input == 0) {
                break;
            }
            int count = input / kindOfCoin[i];
            if (count > 0) {
                resultValue += count;
                input -= count * kindOfCoin[i];
            }
        }
        System.out.println(resultValue);
    }


}
