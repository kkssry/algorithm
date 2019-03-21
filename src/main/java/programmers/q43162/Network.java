package programmers.q43162;

import java.util.Arrays;
import java.util.LinkedList;

public class Network {
    class Computer {
        int index;
        LinkedList<Computer> directConnect;
        boolean connected;

        private Computer(int index) {
            this.index = index+1;
            directConnect = new LinkedList<>();
            connected = false;
        }
    }

    private Computer[] computers;
    private int network;

    public Network() {
    }

    public Network(int comNum) {
        computers = new Computer[comNum];
        for (int i = 0; i < comNum; i++) {
            computers[i] = new Computer(i);
        }
    }

    public void setConnection(int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    this.computers[i].directConnect.add(this.computers[j]);
                }
            }
        }
    }

    private void findNetwork(Computer computer) {
        if (computer == null) {
            return;
        }
        isNewNetwork(computer);
        for (Computer directConnectComputer : computer.directConnect) {
            if (!directConnectComputer.connected) {
                directConnectComputer.connected = true;
                findNetwork(directConnectComputer);
            }
        }
    }

    private void isNewNetwork(Computer computer) {
        if (!computer.connected) {
            network++;
        }
    }

    public void countAllNetwork() {
        for (Computer c : computers) {
            if (!c.connected) {
                findNetwork(c);
            }
        }
    }

    public int getNetwork() {
        return network;
    }

    public int solution(int n, int[][] computers) {
        Network network = new Network(computers.length);
        network.setConnection(computers);
        network.countAllNetwork();
        return network.getNetwork();
    }

    @Override
    public String toString() {
        return "Network{" +
                "computers=" + Arrays.toString(computers) +
                ", network=" + network +
                '}';
    }
}
