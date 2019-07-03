package baekjoon.q1260;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> dfs = new ArrayList<>();
    private static List<Integer> bfs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int lineCount = sc.nextInt();
        int startNodeValue = sc.nextInt();

        Node[] nodes = new Node[nodeCount + 1];
        initNodes(nodes, lineCount, sc);

        startDFS(nodes, nodes[startNodeValue]);
        initNodes(nodes);
        startBFS(nodes, startNodeValue);

        System.out.println(dfs.stream().map(i->i+"").collect(Collectors.joining(" ")));
        System.out.println(bfs.stream().map(i->i+"").collect(Collectors.joining(" ")));
    }

    private static void initNodes(Node[] nodes) {
        for (Node node : nodes) {
            node.isChecked = false;
        }
    }

    private static void startBFS(Node[] nodes2, int startNodeValue) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(nodes2[startNodeValue]);
        while(!nodes.isEmpty()) {
            Node targetNode = nodes.poll();
            if (!targetNode.isChecked) {
                bfs.add(targetNode.value);
                targetNode.isChecked = true;
            }
            for (Integer otherNodeValue : targetNode.otherNodeValues) {
                if (!nodes2[otherNodeValue].isChecked) {
                    nodes.add(nodes2[otherNodeValue]);
                }
            }
        }
    }

    private static void startDFS(Node[] nodes, Node startNode) {
        if (!startNode.isChecked) {
            dfs.add(startNode.value);
            startNode.isChecked = true;
            for (Integer otherNodeValue : startNode.otherNodeValues) {
                startDFS(nodes, nodes[otherNodeValue]);
            }
        }
    }

    private static void initNodes(Node[] nodes, int lineCount, Scanner sc) {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i]= new Node(i);
        }

        for (int i = 0; i < lineCount; i++) {
            int index = sc.nextInt();
            int otherNodeIndex = sc.nextInt();
            nodes[index].setOtherNodeValues(otherNodeIndex);
            nodes[otherNodeIndex].setOtherNodeValues(index);
        }
    }

    static class Node{
        int value;
        Set<Integer> otherNodeValues = new TreeSet<>();
        boolean isChecked;

        Node(int value) {
            this.value = value;
        }

        void setOtherNodeValues(int otherNodeValue) {
            otherNodeValues.add(otherNodeValue);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", otherNodeValues=" + otherNodeValues +
                    ", isChecked=" + isChecked +
                    '}';
        }
    }
}
