package programmers.q42898;

import java.util.Arrays;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] paths = new int[n][m];

        pathInit(paths);
        pathInPuddle(paths, puddles);
        pathDetailInit(paths);
        calculatePathCount(paths);

        System.out.println(Arrays.deepToString(paths));


        answer = paths[n - 1][m - 1] % 1000000007;
        System.out.println(answer);
        return answer;
    }

    private void pathInit(int[][] paths) {
        for (int x = 1; x < paths[0].length; x++) {
            paths[0][x] = 1;
        }

        for (int y = 1; y < paths.length; y++) {
            paths[y][0] = 1;
        }
    }

    private void pathInPuddle(int[][] paths, int[][] puddles) {
        for (int[] puddle : puddles) {
            paths[puddle[0] - 1][puddle[1] - 1] = -1;
        }

//        for (int i = 0; i < puddles.length; i++) {
//            int x = puddles[i][0];
//            int y = puddles[i][1];
//            paths[y - 1][x - 1] = -1;
//        }
    }

    private void pathDetailInit(int[][] paths) {
        for (int x = 1; x < paths[0].length; x++) {
            if (paths[0][x] == -1) {
                for (int j = x; j < paths[0].length; j++) {
                    paths[0][j] = 0;
                }
                break;
            }
        }

        for (int x = 1; x < paths.length; x++) {
            if (paths[x][0] == -1) {
                for (int i = x; i < paths.length; i++) {
                    paths[i][0] = 0;
                }
                break;
            }
        }
    }

    private void calculatePathCount(int[][] paths) {
        for (int y = 1; y < paths.length; y++) {
            for (int x = 1; x < paths[0].length; x++) {
                if (paths[y][x] == -1) {
                    paths[y][x] = 0;
                    continue;
                }

                paths[y][x] = ((paths[y - 1][x] % 1000000007) + (paths[y][x - 1] % 1000000007)) % 1000000007;
            }
        }
    }


}
