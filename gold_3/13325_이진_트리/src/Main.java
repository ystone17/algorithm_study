import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int k, res;
    static int[] edges, newEdges, dp;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());

        edges = new int[(1 << k + 1) - 1];
        newEdges = new int[(1 << k + 1) - 1];
        dp = new int[(1 << k + 1) - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < edges.length; i++) {
            edges[i] = Integer.parseInt(st.nextToken());
        }

        var start = (1 << k) - 1;
        for (int j = 0; j < 1 << k; j += 2) {
            var left = start + j;
            var right = start + j + 1;
            var max = Math.max(edges[left], edges[right]);
            dp[left] = dp[right] = max;
            newEdges[left] = newEdges[right] = max;
        }

        for (int i = k - 1; i > 0; i--) {
            start = (1 << i) - 1;

            for (int j = 0; j < 1 << i; j += 2) {
                var left = start + j;
                var right = start + j + 1;
                var max = Math.max(edges[left] + dp[left * 2 + 1], edges[right] + dp[right * 2 + 1]);
                dp[left] = dp[right] = max;
                newEdges[left] = dp[left] - dp[left * 2 + 1];
                newEdges[right] = dp[right] - dp[right * 2 + 1];
            }
        }

        for (int newEdge : newEdges) {
            res += newEdge;
        }

        System.out.println(res);
    }
}
