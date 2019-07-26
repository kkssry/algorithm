package baekjoon.q5177;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCount = Integer.parseInt(br.readLine()) + 1;
        runTest(testCount, br, bw);
        bw.flush();
    }

    private static void runTest(int testCount, BufferedReader br, BufferedWriter bw) throws IOException {
        for (int i = 1; i < testCount; i++) {
            String firstSentence = br.readLine();
            String secondSentence = br.readLine();
            if (compareIdentity(firstSentence, secondSentence)) {
                bw.write("Data Set " + i + ": equal");
                bw.newLine();
                bw.newLine();
            } else {
                bw.write("Data Set " + i + ": not equal");
                bw.newLine();
                bw.newLine();
            }
        }
    }

    private static boolean compareIdentity(String firstSentence, String secondSentence) {
        boolean isSame = true;

        firstSentence = firstSentence.replaceAll("[\\(\\)\\[\\]\\{\\}.,;:]", " ");
        secondSentence = secondSentence.replaceAll("[\\(\\)\\[\\]\\{\\}.,;:]", " ");

        StringTokenizer st1 = new StringTokenizer(firstSentence);
        StringTokenizer st2 = new StringTokenizer(secondSentence);

        while(st1.hasMoreTokens() && st2.hasMoreTokens()) {
            String word = st1.nextToken();
            String word2 = st2.nextToken();
            if (!word.equalsIgnoreCase(word2)) {
                isSame = false;
            }
        }

        return isSame;
    }

}
