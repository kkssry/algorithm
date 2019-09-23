package baekjoon.q3135;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int fromChannel = sc.nextInt();
        int toChannel = sc.nextInt();
        List<Integer> bookmarkChannels = new ArrayList<>();
        List<Integer> channelCountFromBookMark = new ArrayList<>();
        int bookmarkCount = sc.nextInt();

        for (int i = 0; i < bookmarkCount; i++) {
            bookmarkChannels.add(sc.nextInt());
        }

        for (Integer bookmarkChannel : bookmarkChannels) {
            channelCountFromBookMark.add(Math.abs(toChannel - bookmarkChannel));
        }

        int result = Collections.min(channelCountFromBookMark) + 1;

        System.out.println(Math.min(Math.abs(fromChannel - toChannel), result));
    }
}
