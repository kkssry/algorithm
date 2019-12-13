package baekjoon.q2010;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] plugins = new int[count];
        initPlugins(plugins, sc);
        savePluginCount(count - 1, plugins);
    }

    private static void savePluginCount(int multitabCount, int[] plugins) {
        int pluginCount = 0;
        for (int plugin : plugins) {
            pluginCount += plugin;
        }
        System.out.println(pluginCount - multitabCount);
    }

    private static void initPlugins(int[] plugins, Scanner sc) {
        for (int i = 0; i < plugins.length; i++) {
            plugins[i] = sc.nextInt();
        }
    }

}
