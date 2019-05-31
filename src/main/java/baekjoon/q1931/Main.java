package baekjoon.q1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        Meeting[] meeting = new Meeting[input];

        initMeeting(meeting, input, br);
        Arrays.sort(meeting);

        calculateBestChoice(meeting);
    }


    private static void calculateBestChoice(Meeting[] meeting) {
        int count = 0;
        int endTime = -1;

        for (Meeting meeting1 : meeting) {
            if (endTime <= meeting1.start) {
                endTime = meeting1.end;
                count++;
            }
        }

        System.out.println(count);
    }

    private static void initMeeting(Meeting[] meeting, int input, BufferedReader br) throws IOException {
        for (int i = 0; i < input; i++) {
            int[] startEndTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meeting[i] = new Meeting(startEndTime[0], startEndTime[1]);
        }
    }

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
