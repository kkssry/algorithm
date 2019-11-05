package baekjoon.q1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[][] one = new int[input][input];

        int coreNum = input / 3;

        int[][] paper = new int[coreNum * coreNum][];

        for (int i = 0; i < one.length; i++) {
            one[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int index = 0;

        for (int i = 0; i < coreNum; i++) {
            for (int j = 0; j < coreNum; j++) {
                paper[index++] = callFunc(one, i, j);
            }
        }

        int[] finalResult = Arrays.stream(paper).flatMapToInt(IntStream::of).toArray();

        System.out.println(Arrays.stream(finalResult).filter(i -> i == -1).count());
        System.out.println(Arrays.stream(finalResult).filter(i -> i == 0).count());
        System.out.println(Arrays.stream(finalResult).filter(i -> i == 1).count());


    }

    private static int[] callFunc(int[][] one, int i, int j) {
        List<Integer> list = new ArrayList<>();
        for (int k = 3 * i; k < 3 * (i + 1); k++) {
            for (int l = 3 * j; l < 3 * (j + 1); l++) {
                list.add(one[k][l]);
            }
        }

        if (list.stream().distinct().count() == 1) {
            return list.stream().distinct().mapToInt(p->p).toArray();
        }
        return list.stream().flatMapToInt(IntStream::of).toArray();

    }
}
