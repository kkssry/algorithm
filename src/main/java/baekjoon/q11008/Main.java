package baekjoon.q11008;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int sum = 0;
            String[] arr = br.readLine().split(" ");
            String totalLine = arr[0];
            String copyLine = arr[1];

            while(totalLine.contains(copyLine)) {
                sum++;
                totalLine = totalLine.replaceFirst(copyLine, "1");
            }

            sum += saveResult(totalLine);
            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.flush();
    }

    private static int saveResult(String totalLine) {
        int sum = 0;
        for (int i = 0; i < totalLine.length(); i++) {
            if (totalLine.charAt(i) != '1') {
                sum++;
            }
        }
        return sum;
    }
}
