package baekjoon.q2605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] orders = initOrders(br);
        List<Integer> list = new ArrayList<>();
        saveResult(orders, list);
        String result = list.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void saveResult(int[] orders, List<Integer> list) {
        for (int i = 0; i < orders.length; i++) {
            list.add(list.size() - orders[i], i + 1);
        }
    }

    private static int[] initOrders(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
