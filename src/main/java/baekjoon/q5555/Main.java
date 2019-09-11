package baekjoon.q5555;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetSentence = br.readLine();
        int count = Integer.parseInt(br.readLine());
        int correct = 0;
        for (int i = 0; i < count; i++) {
            String problemSentence = br.readLine();
            problemSentence = problemSentence + problemSentence.substring(0,problemSentence.length() - 1);
            if (isContains(targetSentence, problemSentence)) {
                correct++;
            }
        }
        System.out.println(correct);
    }

    private static boolean isContains(String targetSentence, String problemSentence) {
        return problemSentence.contains(targetSentence);
    }

}
