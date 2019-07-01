package baekjoon.q1321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
입력 : Scanner -> BufferedReader + StringTokenizer
리스트 : ArrayList -> LinkedList
타입 : Integer.parseInt -> chatAt
비교 : minus <-> sum
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int unitCount = Integer.parseInt(br.readLine());
        int[] units = new int[unitCount];
        initUnits(units, br);
        int commandCount = Integer.parseInt(br.readLine());
        List<Integer> results = new LinkedList<>();
        adaptCommand(commandCount, units, br, results);
        results.forEach(System.out::println);
    }

    private static void adaptCommand(int commandCount, int[] units, BufferedReader br, List<Integer> results) throws IOException {
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char commandType = st.nextToken().charAt(0);
            if (commandType == '1') {
                int unit = Integer.parseInt(st.nextToken());
                int changeValue = Integer.parseInt(st.nextToken());
                units[unit - 1] += changeValue;
            }

            if (commandType == '2') {
                int findArmyNumber = Integer.parseInt(st.nextToken());
//                int unitSum = 0;
                for (int j = 0; j < units.length; j++) {
                    findArmyNumber -= units[j];
                    if (findArmyNumber <= 0) {
                        results.add(j + 1);
                        break;
                    }
                }
            }
        }
    }

    private static void initUnits(int[] units, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < units.length; i++) {
            units[i] = Integer.parseInt(st.nextToken());
        }
    }
}
