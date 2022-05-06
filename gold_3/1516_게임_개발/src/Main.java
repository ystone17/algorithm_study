import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] times, dp;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        times = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
            while (true){
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                graph.get(i).add(next);
            }
        }

        for (int i = 1; i < n+1; i++) {
            dp[i] = find(i);
        }
        for (int i = 1; i < dp.length; i++) {
            sb.append(dp[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int k){
        if(dp[k] == 0){
            for (Integer next : graph.get(k)) {
                dp[k] = Math.max(dp[k], find(next));
            }
            dp[k] += times[k];
        }

        return dp[k];
    }

}


