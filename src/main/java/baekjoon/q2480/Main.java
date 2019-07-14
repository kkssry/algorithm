package baekjoon.q2480;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        initNums(nums, sc);
        Map<Integer,Integer> diceDotCount = new TreeMap<>();
        initDiceDotCount(diceDotCount, nums);
        judgeRank(diceDotCount);

    }

    private static void initDiceDotCount(Map<Integer, Integer> diceDotCount, int[] nums) {
        for (int num : nums) {
            diceDotCount.put(num, diceDotCount.getOrDefault(num,0) + 1);
        }
    }

    private static void judgeRank(Map<Integer, Integer> nums) {
        int sameDotCount = nums.values().stream().max(Integer::compare).get();
        int manyOfDiceDot = findManyOfDiceDot(nums, sameDotCount);
        int highetsDiceDot = nums.keySet().stream().max(Integer::compareTo).get();

        Map<Integer,Integer> map = new HashMap<>();
        map.put(3,10000 + manyOfDiceDot * 1000);
        map.put(2, 1000 + manyOfDiceDot * 100);
        map.put(1,highetsDiceDot * 100);

        System.out.println(map.get(sameDotCount));
    }

    private static int findManyOfDiceDot(Map<Integer, Integer> diceDots, int sameDotCount) {
        int targetDiceDot = 0;
        for (Integer integer : diceDots.keySet()) {
            if (diceDots.get(integer) == sameDotCount) {
                targetDiceDot = integer;
            }
        }
        return targetDiceDot;
    }

    private static void initNums(int[] nums, Scanner sc) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
    }

}

