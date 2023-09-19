import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;

    static int[][] baseCount;
    static int[] isFinish, isLeaf;

    static List<List<Child>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        baseCount = new int[n + 1][n + 1];
        isFinish = new int[n + 1];
        isLeaf = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            graph.get(parent).add(new Child(child, capacity));
        }

        for (int i = 1; i < graph.size(); i++) {
            if (graph.get(i).size() == 0) {
                isLeaf[i] = 1;
            }
        }

        fillBaseCount(n);

        for (int i = 1; i < baseCount[n].length; i++) {
            if (isLeaf[i] == 0) {
                continue;
            }

            sb.append(i).append(" ").append(baseCount[n][i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void fillBaseCount(int parent) {
        if (isFinish[parent] == 1) {
            return;
        }

        for (Child child : graph.get(parent)) {
            if (isLeaf[child.num] == 1) {
                baseCount[parent][child.num] += child.capacity;
                continue;
            }

            fillBaseCount(child.num);
            for (int i = 1; i < baseCount[child.num].length; i++) {
                baseCount[parent][i] += baseCount[child.num][i] * child.capacity;
            }
        }

        isFinish[parent] = 1;
    }

    private static class Child {
        int num;
        int capacity;

        public Child(int num, int capacity) {
            this.num = num;
            this.capacity = capacity;
        }
    }
}
