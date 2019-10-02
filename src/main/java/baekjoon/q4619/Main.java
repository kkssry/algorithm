package baekjoon.q4619;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while (!(line = br.readLine()).equals("0 0")) {
            String[] arr = line.split(" ");
            int targetNum = Integer.parseInt(arr[0]);
            int power = Integer.parseInt(arr[1]);
            double difference = Double.MAX_VALUE;
            for (int i = 1; ; i++) {
                double diff = Math.abs(targetNum - Math.pow(i, power));
                if (difference > diff) {
                    difference = diff;
                } else {
                    bw.write(String.valueOf(i - 1));
                    break;
                }
            }
        }
        bw.flush();

    }
}
