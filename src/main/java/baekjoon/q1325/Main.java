package baekjoon.q1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Stack<Node> nodes = new Stack<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nodeAndTestCount = initNodeAndTestCount(br);

        List<Node> nodes = new LinkedList<>();
        initNode(nodes, nodeAndTestCount);
        initDependencyNode(nodes, nodeAndTestCount, br);

        saveEffectiveCounts(nodes);
        int max = nodes.stream().max(Comparator.comparing(i->i.count)).get().count;
        saveNodeWithDependencyNode(nodes, max);
    }

    private static void saveNodeWithDependencyNode(List<Node> nodes, int max) {
        System.out.println(nodes.stream().filter(node->node.count == max).map(i->i.number+"").collect(Collectors.joining(" ")));
    }

    private static void saveEffectiveCounts(List<Node> nodes) {
        int nodesSize = nodes.size();
        for (Node node : nodes) {
            boolean[] checkManager = new boolean[nodesSize];
            checkManager[node.number - 1] = true;
            int amount = 1;
            int count = findDependencyNode(node, checkManager,amount);
            node.count = count;
        }
    }

    private static int findDependencyNode(Node node, boolean[] checkManager, int amount) {
        for (Node dependencyNode : node.dependencyNodes) {
            if (!checkManager[dependencyNode.number - 1]) {
                checkManager[dependencyNode.number - 1] = true;
                amount+=1;
                amount = findDependencyNode(dependencyNode,checkManager,amount);
            }
        }
        return amount;
    }

    private static void initDependencyNode(List<Node> nodes, int[] nodeAndTestCount, BufferedReader br) throws IOException {
        for (int i = 0; i < nodeAndTestCount[1]; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes.get(arr[1] - 1).dependencyNodes.add(nodes.get(arr[0] - 1));
        }
    }

    private static void initNode(List<Node> nodes, int[] nodeAndTestCount) {
        for (int i = 0; i < nodeAndTestCount[0]; i++) {
            nodes.add(new Node(i + 1));
        }
    }

    private static int[] initNodeAndTestCount(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }


    static class Node {
        List<Node> dependencyNodes = new LinkedList<>();
        int number;
        int count;

        public Node(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "dependencyNodes=" + dependencyNodes +
                    ", number=" + number +
                    '}';
        }
    }
}
