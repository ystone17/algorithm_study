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

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] answerSeq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(0);
        answerSeq = new int[n];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            answerSeq[i] = Integer.parseInt(st.nextToken());
        }

        int dfs = dfs(1, 0);
        System.out.println(dfs == -1 ? 0 : 1);
    }

    private static int dfs(int root, int seqIdx) {

        List<Integer> children = graph.get(root);
        int size = 1;

        for (int i = 0; i < children.size() - 1; i++) {
            if (!children.contains(answerSeq[seqIdx + size])) {
                return -1;
            }

            int dfs = dfs(answerSeq[seqIdx + size], seqIdx + size);
            if (dfs == -1) {
                return -1;
            }
            size += dfs;

        }

        return size;
    }

}
