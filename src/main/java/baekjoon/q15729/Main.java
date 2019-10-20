package baekjoon.q15729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int finalNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] results = br.readLine().split(" ");
        boolean[] resultButtons = new boolean[count];
        initResultButtons(resultButtons, results);
        boolean[] buttons = new boolean[count];
        saveResult(resultButtons, buttons);
        System.out.println(finalNumber);
    }

    private static void initResultButtons(boolean[] resultButtons, String[] results) {
        for (int i = 0; i < results.length; i++) {
            if (results[i].equals("1")) {
                resultButtons[i] = true;
            }
        }
    }

    private static void saveResult(boolean[] results, boolean[] buttons) {
        int firstLightIndex = findFirstLight(results);
        if (firstLightIndex < buttons.length) {
            finalNumber++;
        }
        setting(firstLightIndex, buttons);
        for (int i = firstLightIndex; i < buttons.length; i++) {
            if (results[i] == buttons[i]) {
                continue;
            }
            finalNumber++;
            setting(i, buttons);
        }
    }

    private static void setting(int index, boolean[] buttons) {
        if (index < buttons.length) {
            buttons[index] = !buttons[index];
        }
        if (index + 1 < buttons.length) {
            buttons[index + 1] = !buttons[index + 1];
        }
        if (index + 2 < buttons.length) {
            buttons[index + 2] = !buttons[index + 2];
        }
    }

    private static int findFirstLight(boolean[] results) {
        int index = results.length;
        for (int i = 0; i < results.length; i++) {
            if (results[i]) {
                index = i;
                return index;
            }
        }
        return index;
    }

}
