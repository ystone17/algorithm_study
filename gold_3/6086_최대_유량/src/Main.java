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

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] flowRates = new int[52][52];
    static int[] visited = new int[52];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 52; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = calcNodeNum(st.nextToken());
            int v = calcNodeNum(st.nextToken());
            int flowRate = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            flowRates[u][v] = flowRate;
        }

        visited[0] = 1;
        System.out.println(calcTotalFlowRate(-1, 0));
    }

    private static int calcNodeNum(String s) {
        int node = s.charAt(0) - 65;
        return node < 26 ? node : node - 6;
    }

    static int calcTotalFlowRate(int parent, int me) {
        List<Integer> children = graph.get(me);
        if (me == 'Z' - 65) {
            return Integer.MAX_VALUE;
        }

        if (children.isEmpty()) {
            return 0;
        }

        int totalFlowRate = 0;

        for (Integer child : children) {
            if (child == parent) {
                continue;
            }

            totalFlowRate += Math.min(flowRates[me][child], calcTotalFlowRate(me, child));
        }

        return totalFlowRate;
    }
}
