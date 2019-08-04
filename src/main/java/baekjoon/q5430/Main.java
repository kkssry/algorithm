package baekjoon.q5430;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        String[] results = new String[testCount];
        executeTest(testCount, sc, results);
        Arrays.stream(results).forEach(System.out::println);
    }

    private static void executeTest(int testCount, Scanner sc, String[] results) {
        for (int i = 0; i < testCount; i++) {
            String command = sc.next();
            int numberCount = sc.nextInt();
            List<Integer> numbers = new ArrayList<>();
            initNumbers(numbers, sc);
            int[] numberTo = new int[numbers.size()];
            initNumberTo(numberTo, numbers);
            results[i] = calculateResult(command, numberTo);
        }
    }

    private static void initNumberTo(int[] numberTo, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            numberTo[i] = numbers.get(i);
        }
    }

    private static String calculateResult(String command, int[] numbers) {
        boolean isTurnAround = false;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'D') {
                if (isTurnAround) {
                    if (!removeNumberFromBack(numbers)) {
                        return "error";
                    }
                }

                if (!isTurnAround) {
                    if (!removeNumberFront(numbers)) {
                        return "error";
                    }
                }
            }

            if (command.charAt(i) == 'R') {
                isTurnAround = !isTurnAround;
            }

        }
        return saveResult(numbers, isTurnAround);
    }

    private static boolean removeNumberFront(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                numbers[i] = 0;
                return true;
            }
        }
        return false;
    }

    private static boolean removeNumberFromBack(int[] numbers) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > 0) {
                numbers[i] = 0;
                return true;
            }
        }
        return false;
    }

    private static String saveResult(int[] numbers, boolean isTurnAround) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = (int) Arrays.stream(numbers).filter(i -> i > 0).count();
        if (count > 1) {
            int[] resultNumberContainer = new int[count];
            if (isTurnAround) {
                inputToContainerFromBack(resultNumberContainer, numbers);
            } else {
                inputToContainerFromFront(resultNumberContainer, numbers);
            }
            String line = Arrays.stream(resultNumberContainer).filter(i -> i > 0).mapToObj(String::valueOf).collect(Collectors.joining(","));
            sb.append(line);
        }

        if (count == 1) {
            int value = findNotZeroValue(numbers);
            sb.append(value);
        }

        sb.append("]");
        return sb.toString();
    }

    private static void inputToContainerFromFront(int[] resultNumberContainer, int[] numbers) {
        int index = 0;
        for (int element : numbers) {
            if (element > 0) {
                resultNumberContainer[index++] = element;
            }
        }
    }

    private static int findNotZeroValue(int[] numbers) {
        int value = 0;
        for (int number : numbers) {
            if (number > 0) {
                value = number;
                break;
            }
        }
        return value;
    }

    private static void inputToContainerFromBack(int[] resultNumberContainer, int[] numbers) {
        int index = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            int element = numbers[i];
            if (element > 0) {
                resultNumberContainer[index++] = element;
            }
        }
    }

    private static void initNumbers(List<Integer> numbers, Scanner sc) {
        String numberLine = sc.next();
        numberLine = numberLine.replaceAll("[\\[\\]]", "");
        if (numberLine.length() > 1) {
            int[] arr = Arrays.stream(numberLine.split(",")).mapToInt(Integer::parseInt).toArray();
            addNumber(arr, numbers);
        }
        if (numberLine.length() == 1) {
            numbers.add(Integer.parseInt(numberLine));
        }
    }

    private static void addNumber(int[] arr, List<Integer> numbers) {
        for (int value : arr) {
            numbers.add(value);
        }
    }
}
