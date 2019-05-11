package baekjoon.q5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = new ArrayList<>();
        Node rootNode = new Node(Integer.parseInt(br.readLine()));

        try {
            while (true) {
                nums.add(Integer.parseInt(br.readLine()));
            }
        } catch (NumberFormatException e) {
        }

        for (Integer num : nums) {
            doPosition(rootNode, num);
        }

        callPostCircle(rootNode);
    }

    private static void doPosition(Node currentNode, int input) {
        if (currentNode.leftNode == null && currentNode.value > input) {            //비교노드가 더 큰경우 --> 오른쪽 자식
            Node newNode = new Node(input);
            newNode.rootNode = currentNode;
            currentNode.leftNode = newNode;
            return;
        }

        if (currentNode.rightNode == null && currentNode.value < input) {           //비교 노드가 작음 --> 왼쪽 자식
            Node newNode = new Node(input);
            newNode.rootNode = currentNode;
            currentNode.rightNode = newNode;
            return;
        }

        if (currentNode.value > input) {
            doPosition(currentNode.leftNode, input);
        }

        if (currentNode.value < input) {
            doPosition(currentNode.rightNode, input);
        }

    }

    private static void callPostCircle(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        callPostCircle(currentNode.leftNode);
        callPostCircle(currentNode.rightNode);
        System.out.println(currentNode.value);
    }

    static class Node {
        int value;
        Node rootNode = null;
        Node leftNode = null;
        Node rightNode = null;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}


