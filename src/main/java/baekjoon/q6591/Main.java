package baekjoon.q6591;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        String[] arr;
        long first;
        long second;
        long answer;
        long divider;

        while (!(line = br.readLine()).equals("0 0")) {
            arr = line.split(" ");
            first = Long.parseLong(arr[0]);
            second = Long.parseLong(arr[1]);
            second = Math.min(second, first - second);
            divider = 1;
            answer = 1;
            while(second-- > 0) {
                answer *= first--;
                answer /= divider++;
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
    }
}
