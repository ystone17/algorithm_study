import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static long[][] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));

    }

    static long dfs(int y, int x) {
        if (visited[y][x] != -1) {
            return visited[y][x];
        }

        if (y == n - 1 && x == n - 1) {
            return visited[y][x] = 1;
        }

        int[] ny = {y, y + map[y][x]};
        int[] nx = {x + map[y][x], x};

        visited[y][x] = 0;
        for (int i = 0; i < 2; i++) {
            if (ny[i] < 0 || ny[i] >= n || nx[i] < 0 || nx[i] >= n) continue;
            visited[y][x] += dfs(ny[i], nx[i]);
        }

        return visited[y][x];
    }
}
