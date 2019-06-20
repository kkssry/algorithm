package baekjoon.q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetCharacter = br.readLine();
        String[] alphates = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        calculateNonAlphabetCount(alphates,targetCharacter);
    }

    private static void calculateNonAlphabetCount(String[] alphates, String target) {
        for (String alphate : alphates) {
            if (target.contains(alphate)) {
                target = target.replace(alphate, "a");
            }
        }
        System.out.println(target.length());
    }
}
