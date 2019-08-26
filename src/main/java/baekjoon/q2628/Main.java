package baekjoon.q2628;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int columnLength = sc.nextInt();
        int rowLength = sc.nextInt();
        int cutCount  = sc.nextInt();
        saveResult(columnLength, rowLength, cutCount, sc);
    }

    private static void saveResult(int columnLength, int rowLength, int cutCount, Scanner sc) {
        List<Integer> rows = new ArrayList<>();
        rows.add(0); rows.add(rowLength);
        List<Integer> columns = new ArrayList<>();
        columns.add(0);columns.add(columnLength);
        for (int i = 0; i < cutCount; i++) {
            int rowColumnIdentifier = sc.nextInt();
            if (rowColumnIdentifier == 0) {
                rows.add(sc.nextInt());
            }
            if (rowColumnIdentifier == 1) {
                columns.add(sc.nextInt());
            }
        }
        saveArea(rows, columns);
    }

    private static void saveArea(List<Integer> rows, List<Integer> columns) {
        int max = 0;
        Collections.sort(rows);
        Collections.sort(columns);
        for (int i = 1; i < rows.size(); i++) {
            int differentRow = rows.get(i) - rows.get(i - 1);
            for (int j = 1; j < columns.size(); j++) {
                int differentColumn = columns.get(j) - columns.get(j - 1);
                int area = differentRow * differentColumn;
                if (max < area) {
                    max = area;
                }
            }
        }
        System.out.println(max);
    }
}
