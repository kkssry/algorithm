package baekjoon.q1967;

import java.util.*;

public class Main {
    private static int maxLength = 0;
    private static int distanceValue = 0;
    private static int rootFromDistance = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt() + 1;
        if (nodeCount == 2) {
            System.out.println(0);
            return;
        }
        Node[] nodes = new Node[nodeCount];
        initNodes(nodes);
        initRelatedNodes(nodes, sc);

        int[] lengths = new int[nodes.length];
        initLengths(lengths, nodes);

        findDistanceNodeValueFromRootNode(nodes[1]);
        initializeNodes(nodes, lengths);

        saveMaxLength(nodes, lengths);
        System.out.println(Math.max(maxLength, rootFromDistance));
    }

    private static void findDistanceNodeValueFromRootNode(Node rootNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.isChecked = true;
            for (Node node1 : node.nodes) {
                if (!node1.isChecked) {
                    node1.length += node.length;
                    queue.add(node1);
                }
            }
            findDistanceNodeValue(node);
        }
    }

    private static void findDistanceNodeValue(Node node) {
        if (maxLength < node.length) {
            maxLength = node.length;
            distanceValue = node.value;
            rootFromDistance = node.length;
        }
    }

    private static void saveMaxLength(Node[] nodes, int[] lengths) {
        maxLength = 0;
        startDFS(nodes[distanceValue], lengths);
    }

    private static void initializeNodes(Node[] nodes, int[] lengths) {
        for (int i = 1; i < nodes.length; i++) {
            nodes[i].length = lengths[i];
            nodes[i].isChecked = false;
        }
    }

    private static void initLengths(int[] lengths, Node[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            lengths[i] = nodes[i].length;
        }
    }

    private static void startDFS(Node startNode, int[] lengths) {
        Stack<Node> queue = new Stack<>();
        queue.add(startNode);
        Node topLevelNode = queue.peek();
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            node.isChecked = true;
            if (topLevelNode.value > node.value) {
                topLevelNode = node;
            }

            for (Node relationNode : node.nodes) {
                if (!relationNode.isChecked) {
                    relationNode.length += node.length;
                    checkLength(relationNode.length, topLevelNode, lengths);
                    queue.add(relationNode);
                }
            }
        }
    }

    private static void checkLength(int length, Node topLevelNode, int[] lengths) {
        int beetWeenLength = length;
        if (topLevelNode.value != 0) {
            beetWeenLength -= lengths[topLevelNode.value];
        }

        if (maxLength < beetWeenLength) {
            maxLength = beetWeenLength;
        }
    }

    private static void initRelatedNodes(Node[] nodes, Scanner sc) {
        for (int i = 1; i < nodes.length - 1; i++) {
            int parentNodeValue = sc.nextInt();
            int childNodeValue = sc.nextInt();
            int betweenLength = sc.nextInt();

            nodes[childNodeValue].length = betweenLength;
            nodes[parentNodeValue].nodes.add(nodes[childNodeValue]);
            nodes[childNodeValue].nodes.add(nodes[parentNodeValue]);
        }
    }

    private static void initNodes(Node[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
    }

    static class Node {
        int value;
        int length;
        boolean isChecked;
        List<Node> nodes = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }
    }
}
