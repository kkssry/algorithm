package baekjoon.q1071;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        Number[] nums = new Number[count];
        initNums(nums, sc);
        Arrays.sort(nums);

        Set<Integer> startNumbers = new TreeSet<>();
        initStartNumbers(startNumbers, nums);

        List<Integer> results = saveResult(nums, startNumbers);
        System.out.println(results.stream().map(i->i+"").collect(Collectors.joining(" ")));
    }

    private static void initStartNumbers(Set<Integer> startNumbers, Number[] nums) {
        for (Number num : nums) {
            startNumbers.add(num.value);
        }
    }

    private static List<Integer> saveResult(Number[] nums, Set<Integer> startNumbers) {
        for (int startNum : startNumbers) {
            Number[] copyNums = new Number[nums.length];
            deepCopy(copyNums, nums);
            List<Integer> numbers = new ArrayList<>();
            checkStartNum(copyNums, startNum);
            numbers = Sort(copyNums, startNum, numbers);
            if (numbers.size() == copyNums.length) {
                return numbers;
            }
        }

        return reverseNums(nums);
    }

    private static void deepCopy(Number[] copyNums, Number[] nums) {
        for (int i = 0; i < nums.length; i++) {
            copyNums[i] = new Number(nums[i].value);
        }
    }

    private static List<Integer> reverseNums(Number[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            numbers.add(nums[i].value);
        }
        return numbers;
    }

    private static List<Integer> Sort(Number[] nums, int startNum, List<Integer> numbers) {
        int comparisonNum = startNum;
        numbers.add(startNum);
        for (int i = 0; i < nums.length; i++) {
            for (Number num : nums) {
                if (!num.isCheck && (comparisonNum >= num.value || comparisonNum + 1 < num.value)) {
                    num.isCheck = true;
                    numbers.add(num.value);
                    comparisonNum = num.value;
                    break;
                }
            }
        }

        return lastSortChance(nums, numbers);
    }

    private static List<Integer> lastSortChance(Number[] nums, List<Integer> numbers) {
        List<Integer> lastChanceNumber = new LinkedList<>(numbers);

        for (Number num : nums) {
            if (!num.isCheck) {

                for (int j = lastChanceNumber.size() - 1; j >= 1; j--) {
                    if (isWannaBeSort(lastChanceNumber, j, num.value)) {
                        if (j == lastChanceNumber.size() - 1) {
                            lastChanceNumber.add(j , num.value);
                            break ;
                        }
                        lastChanceNumber.add(j - 1, num.value);
                        num.isCheck = true;
                        break ;
                    }
                }
            }
        }

        if (lastChanceNumber.size() == nums.length) {
            return lastChanceNumber;
        }

        return numbers;
    }

    private static boolean isWannaBeSort(List<Integer> list, int j, int num) {
        if (j == list.size() - 1) {
            if (checkLastIndex(list, j, num)) {
                return true;
            }
        }
        return (list.get(j) != num + 1) && (list.get(j - 1) + 1 != num );
    }

    private static boolean checkLastIndex(List<Integer> list, int j, int num) {
        return list.get(j) + 1 != num;

    }

    private static void checkStartNum(Number[] nums, int startNum) {
        for (Number num : nums) {
            if (num.value == startNum) {
                num.isCheck = true;
                return;
            }
        }
    }

    private static void initNums(Number[] nums, Scanner sc) {
        for (int i = 0; i < nums.length; i++) {
            int value = sc.nextInt();
            nums[i] = new Number(value);
        }
    }

    static class Number implements Comparable<Number>{
        int value;
        boolean isCheck;

        Number(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " ";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number = (Number) o;
            return value == number.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public int compareTo(Number number) {
            return Integer.compare(this.value, number.value);
        }
    }
}

