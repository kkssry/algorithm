package baekjoon.q1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int count1 = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currentChannel = inputCurrentChannel(br);
        String[] errorButtons = new String[Integer.parseInt(br.readLine())];
        setErrorButtons(errorButtons, br);
        calculateMinimumCount(currentChannel, errorButtons);
        comparison(currentChannel);
        System.out.println(count1);
    }

    private static void comparison(String currentChannel) {
        int nowChannel = Integer.parseInt(currentChannel);
        nowChannel = Math.abs(100 - nowChannel);
        count1 = Math.min(count1, nowChannel);
    }

    private static void calculateMinimumCount(String currentChannel, String[] errorButtons) {
        int targetNumber = Integer.parseInt(currentChannel);

        for (int i = 0; i <= 999999; i++) {
            if (isPushButton(errorButtons,i)) {
                continue;
            }

            int count = calculateCount(i, targetNumber);

            if (count1 > count) {
                count1 = count;
            }
        }
    }

    private static boolean isPushButton(String[] errorButtons, int i) {
        String num = i + "";
        for (String errorButton : errorButtons) {
            if (num.contains(errorButton)) {
                return true;
            }
        }
        return false;
    }

    private static int calculateCount(int i, int currentChannel) {
        String a = i + "";
        int count = a.length();
        count += Math.abs(i - currentChannel);
        return count;
    }

    private static void setErrorButtons(String[] errorButtons, BufferedReader br) throws IOException {
        String[] arr = new String[errorButtons.length];
        for (int i = 0; i < errorButtons.length; i++) {
            if (i == 0) {
                arr = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
            }
            errorButtons[i] = arr[i];
        }
    }

    private static String inputCurrentChannel(BufferedReader br) throws IOException {
        return br.readLine();
    }
}
