package programmers.school.week4;


import java.util.Arrays;

public class 도둑질 {
    public int solution(int[] money) {
        int answer = 0;
        int length = money.length;

        if (money.length == 3) {
            int max = -1;
            for (int i = 0; i < money.length; i++) {
                if (max < money[i]) {
                    max = money[i];
                }
            }
            return max;
        }

//        long[] case1 = new long[length - 1];        //첫번째 집 방문
        long[] case2 = new long[length];        //두번째 집 방문

        case2[0] = money[0];
        case2[1] = 0;
        case2[2] = money[2] + case2[0];
        case2[3] = case2[0] + money[3];

        for (int i = 4; i < case2.length-1; i++) {

            if (i == 4) {
                case2[i] = case2[i - 2] + money[i];
                continue;
            }

            if (i > 4) {
                case2[i] = Math.max(case2[i - 2], case2[i - 3]) + money[i];
            }

        }
        long case1Max = Math.max(case2[length - 2], case2[length - 3]);

        case2[0] = money[0];
        case2[1] = money[1];
        case2[2] = money[2];
        case2[3] = money[3] + case2[1];

        for (int i = 4; i < case2.length; i++) {

//            if (i == 4) {
//                case2[i] = Math.case2[i - 3] + money[i];
//                continue;
//            }
//
//            if (i == 5) {
//                case2[i] = case2[i - 2] + money[i];
//                continue;
//            }

            case2[i] = Math.max(case2[i - 2], case2[i - 3]) + money[i];
        }
        System.out.println(Arrays.toString(case2));
        long case2Max = Math.max(case2[length - 1], case2[length - 2]);
        answer = (int)Math.max(case1Max,case2Max);

        return answer;
    }
}
