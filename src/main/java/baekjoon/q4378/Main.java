package baekjoon.q4378;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sentence;
        while((sentence = br.readLine()) != null && sentence.length() != 0) {
            Map<String, String> words = new HashMap<>();
            initWords(words);
            String[] vocas = sentence.split("");
            printResult(vocas, words, bw);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void printResult(String[] vocas, Map<String, String> words, BufferedWriter bw) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (String voca : vocas) {
            if (voca.equals(" ")) {
                sb.append(" ");
                continue;
            }
            sb.append(words.get(voca));
        }
        bw.write(sb.toString());
        bw.newLine();
    }

    private static void initWords(Map<String, String> words) {
        words.put("1","`");words.put("2","1");words.put("3","2");words.put("4","3");words.put("5","4");words.put("6","5");words.put("7","6");words.put("8","7");words.put("9","8");words.put("0","9");words.put("-","0");words.put("=","-");
        words.put("Q","Q");words.put("W","Q");words.put("E","W");words.put("R","E");words.put("T","R");words.put("Y","T");words.put("U","Y");words.put("I","U");words.put("O","I");words.put("P","O");words.put("[","P");words.put("]","[");words.put("\\","]");
        words.put("A","A");words.put("S","A");words.put("D","S");words.put("F","D");words.put("G","F");words.put("H","G");words.put("J","H");words.put("K","J");words.put("L","K");words.put(";","L");words.put("'",";");
        words.put("Z","Z");words.put("X","Z");words.put("C","X");words.put("V","C");words.put("B","V");words.put("N","B");words.put("M","N");words.put(",","M");words.put(".",",");words.put("/",".");
    }
}
