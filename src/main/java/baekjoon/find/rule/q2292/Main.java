package baekjoon.find.rule.q2292;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int answer = 0;
        long num;

        if (input == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < input; i++) {
            num = (3 * i) * (i + 1);
            if ( num +1 >= input) {
                answer = i;
                break;
            }
        }

        System.out.println(answer + 1);
    }
}
