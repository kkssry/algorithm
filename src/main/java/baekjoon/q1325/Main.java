package baekjoon.q1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nodeAndTestCount = initNodeAndTestCount(br);

        List<Node> nodes = initNode(nodeAndTestCount, br);
        initDependencyNode(nodes, nodeAndTestCount, br);

        System.out.println(nodes);

        List<Integer> list = countNode(nodes);
        List<Integer> maxVal = new ArrayList<>();
        int max = list.stream().mapToInt(i->i).max().getAsInt();
        System.out.println(max);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                maxVal.add(i + 1);
            }
        }
        maxVal.stream().forEach(System.out::println);
    }

    private static List<Integer> countNode(List<Node> nodes) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            list.add(findDependencyNode(nodes.get(i)));
        }
        System.out.println("list : " + list);
        return list;
    }

    private static int findDependencyNode(Node node) {
        int count = 0;
        Queue<Node> nodes = new LinkedList<>();
        if (node.dependencyNode != null) {
            nodes.add(node.dependencyNode);
            count++;
        }
        while(!nodes.isEmpty()) {
            Node node1 = nodes.poll();
            if (node1.dependencyNode != null) {
                nodes.add(node1.dependencyNode);
                count++;
            }
        }
        return count;
    }

    private static void initDependencyNode(List<Node> nodes, int[] nodeAndTestCount, BufferedReader br) throws IOException {

        for (int i = 0; i < nodeAndTestCount[1]; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes.get(arr[0] - 1).dependencyNode = nodes.get(arr[1] - 1);
        }

    }

    private static List<Node> initNode(int[] nodeAndTestCount, BufferedReader br) throws IOException {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeAndTestCount[0]; i++) {
            nodes.add(new Node(i + 1));
        }
        return nodes;
    }

    private static int[] initNodeAndTestCount(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }


    static class Node {
        int number;
        Node dependencyNode;

        public Node(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", dependencyNode=" + dependencyNode +
                    '}';
        }
    }
}
