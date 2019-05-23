package baekjoon.use.string.q10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] str = input.split("");

        String[] alphabets = "abcdefghijklmnopqrstuvwxyz".split("");
        int[] result = new int[26];
        initResultFunc(result);

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < alphabets.length; j++) {
                if (str[i].equals(alphabets[j]) && result[j] == -1) {
                    result[j] = i;
                    break;
                }
            }
        }

        String[] arr = new String[26];
        callCorrectContainer(result, arr);
        System.out.println(String.join(" ", arr));
    }

    private static void callCorrectContainer(int[] result, String[] arr) {
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i] +"";
        }
    }

    private static void initResultFunc(int[] result) {
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
    }
}
