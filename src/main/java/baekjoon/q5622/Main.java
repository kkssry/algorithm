package baekjoon.q5622;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;

        Map<String,Integer> stringManage = new HashMap<>();

        char word = 'A';                                            // 첫번째 풀이
        for (int i = 2; i <= 6 ; i++) {
            for (int j = 0; j < 3; j++) {
                stringManage.put(Character.toString(word),i+1);
                word++;
            }

        }

        for (int i = 7; i <= 9; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < 4; j++) {
                    stringManage.put(Character.toString(word),i+1);
                    word++;
                }

            }
            if (i % 2 == 0) {
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < 3; k++) {
                        stringManage.put(Character.toString(word),i+1);
                        word++;
                    }
                }
            }
        }

//        stringManage.put("A",3);stringManage.put("B",3);stringManage.put("C",3);      // 두번째 풀이
//        stringManage.put("D",4);stringManage.put("E",4);stringManage.put("F",4);
//        stringManage.put("G",5);stringManage.put("H",5);stringManage.put("I",5);
//        stringManage.put("J",6);stringManage.put("K",6);stringManage.put("L",6);
//        stringManage.put("M",7);stringManage.put("N",7);stringManage.put("O",7);
//        stringManage.put("P",8);stringManage.put("Q",8);stringManage.put("R",8);stringManage.put("S",8);
//        stringManage.put("T",9);stringManage.put("U",9);stringManage.put("V",9);
//        stringManage.put("W",10);stringManage.put("X",10);stringManage.put("Y",10);stringManage.put("Z",10);


        String[] words = br.readLine().split("");
        for (int i = 0; i < words.length; i++) {
            sum += stringManage.get(words[i]);
        }

//        bw.write(String.valueOf(sum));
//        bw.flush();
    }
}
