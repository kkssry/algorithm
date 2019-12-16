package baekjoon.q1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> preOrder = new ArrayList<>();
        List<String> inOrder = new ArrayList<>();
        List<String> postOrder = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[count];
        Map<String, Integer> map = new HashMap<>();
        initNodes(nodes, map);
        initLeftRightNode(nodes, map, br);
        initPreOrder(nodes, preOrder);
        initInOrder(nodes, inOrder);
        initPostOrder(nodes, postOrder);
        saveResult(preOrder, inOrder, postOrder);
    }

    private static void saveResult(List<String> preOrder, List<String> inOrder, List<String> postOrder) {
        for (String s : preOrder) {
            System.out.print(s);
        }
        System.out.println();
        for (String s : inOrder) {
            System.out.print(s);
        }
        System.out.println();
        for (String s : postOrder) {
            System.out.print(s);
        }
    }

    private static void initPreOrder(Node[] nodes, List<String> preOrder) {
        startPreOrder(nodes[0], preOrder);
    }

    private static void startPreOrder(Node startNode, List<String> preOrder) {
        preOrder.add(startNode.value);
        if (startNode.leftNode != null) {
            startPreOrder(startNode.leftNode, preOrder);
        }
        if (startNode.rightNode != null) {
            startPreOrder(startNode.rightNode, preOrder);
        }
    }

    private static void initInOrder(Node[] nodes, List<String> inOrder) {
        startInOrder(nodes[0], inOrder);
    }

    private static void startInOrder(Node startNode, List<String> inOrder) {
        if (startNode.leftNode != null) {
            startInOrder(startNode.leftNode, inOrder);
        }
        inOrder.add(startNode.value);
        if (startNode.rightNode != null) {
            startInOrder(startNode.rightNode, inOrder);
        }
    }

    private static void initPostOrder(Node[] nodes, List<String> postOrder) {
        startPostOrder(nodes[0], postOrder);
    }

    private static void startPostOrder(Node startNode, List<String> postOrder) {
        if (startNode.leftNode != null) {
            startPostOrder(startNode.leftNode, postOrder);
        }
        if (startNode.rightNode != null) {
            startPostOrder(startNode.rightNode, postOrder);
        }
        postOrder.add(startNode.value);
    }

    private static void initLeftRightNode(Node[] nodes, Map<String, Integer> map, BufferedReader br) throws IOException {
        for (Node node : nodes) {
            String[] nodeInfo = br.readLine().split(" ");
            Node rootNode = nodes[map.get(nodeInfo[0])];
            if (!nodeInfo[1].equals(".")) {
                rootNode.leftNode = nodes[map.get(nodeInfo[1])];
            }
            if (!nodeInfo[2].equals(".")) {
                rootNode.rightNode = nodes[map.get(nodeInfo[2])];
            }
        }
    }

    private static void initNodes(Node[] nodes, Map<String, Integer> map) throws IOException {
        for (int i = 0; i < nodes.length; i++) {
            int word = 65 + i;
            nodes[i] = new Node(String.valueOf((char) word));
            map.put(nodes[i].value, i);
        }
    }


    static class Node {
        String value;
        Node leftNode;
        Node rightNode;

        Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
