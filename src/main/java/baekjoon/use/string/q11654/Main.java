package baekjoon.use.string.q11654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Scanner sc = new Scanner(System.in);
//        sc.next();      공백은 무시하고 데이터만 입력받는다.                ex )     a   b 일시 a만 출력 한다.
//        sc.nextLine();  한줄 단위로 입력을 받는다. 공백도 입력받는다.        ex )     a   b 일시 한줄 입력을 그대로받아  그대로 출력

        String word = br.readLine();
        char oneWord = word.charAt(0);
        System.out.println((int)oneWord);
    }
}
