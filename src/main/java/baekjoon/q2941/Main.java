package baekjoon.q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String[] alphates = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String voca = calculateNonAlphabetCount(alphates,target);
        System.out.println(voca);
        calculateAlphabetCount(alphates, target, voca);
    }

    private static String calculateNonAlphabetCount(String[] alphates, String target) {
        String copyTarget = target + "";
        for (int i = 0; i < alphates.length; i++) {
            if (target.contains(alphates[i])) {
                copyTarget = copyTarget.replaceAll(alphates[i],"");
            }
        }
        return copyTarget;
    }

    private static void calculateAlphabetCount(String[] alphates, String target, String voca) {
        int count = 0;
        String[] vocas = voca.split("");
        for (int i = 0; i < vocas.length; i++) {
            target = target.replace(vocas[i],"");
            count++;
        }
        System.out.println("tsrgt:" + target);

        while(target.length() != 0) {
            for (int i = 0; i < alphates.length; i++) {
                if (target.contains(alphates[i])) {
                    target = target.replace(alphates[i],"");
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
