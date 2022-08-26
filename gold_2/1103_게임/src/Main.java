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

    static int h, w;
    static int[][] map;
    static int[] dp, visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h * w; i++) {
            graph.add(new ArrayList<>());
        }

        map = new int[h][w];
        dp = new int[h * w];
        visited = new int[h * w];

        for (int i = 0; i < h; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == 'H') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = c - '0';
                }
                j++;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k] * map[i][j];
                    int nx = j + dx[k] * map[i][j];
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    if (map[ny][nx] == 0) continue;
                    graph.get(i * w + j).add(ny * w + nx);
                }
            }
        }

        visited[0] = 1;
        int dfs = dfs(0, 0);
        if (dfs == Integer.MAX_VALUE) {
            dfs = -1;
        }
        System.out.println(dfs);
    }

    static int dfs(int k, int cnt) {
        if (graph.get(k).size() == 0) {
            return 1;
        }

        if (dp[k] != 0) return dp[k];

        int res = 0;
        for (Integer next : graph.get(k)) {
            if (visited[next] == 1) return Integer.MAX_VALUE;
            visited[next] = 1;
            int dfs = dfs(next, cnt + 1);
            if(dfs == Integer.MAX_VALUE) return dfs;
            res = Math.max(res, dfs);
            visited[next] = 0;
        }

        return dp[k] = res + 1;
    }
}
