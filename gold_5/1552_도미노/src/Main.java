import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
    static int[] visited;
    static long[][] points;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new int[n];
        points = new long[n][n];
        for (int y = 0; y < n; y++) {
            char[] row = br.readLine().toCharArray();
            for (int x = 0; x < n; x++) {
                if (row[x] >= 'A') {
                    points[y][x] = -(row[x] - 'A' + 1);
                } else {
                    points[y][x] = row[x] - '0';
                }
            }
        }
        var arr = new int[n];

        dfs(0, 0, 1, arr);
        System.out.printf("%d\n%d", min, max);
    }

    public static void dfs(int depth, int selfCount, long total, int[] arr) {
        if (depth >= n) {
            int cycleNum = cycleNum(arr);
            if (cycleNum % 2 == 0) {
                total = -total;
            }
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            arr[depth] = i;
            var self = depth == i ? 1 : 0;
            dfs(depth + 1, selfCount + self, total * points[depth][i], arr);
            arr[depth] = -1;
            visited[i] = 0;
        }
    }

    public static int cycleNum(int[] arr) {
        var num = 0;
        var isCycle = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if(i == arr[i]) {
                num++;
                isCycle[i] = true;
                continue;
            }

            if (isCycle[i]) {
                continue;
            }

            num++;
            var cur = i;
            while (!isCycle[cur]) {
                isCycle[cur] = true;
                cur = arr[cur];
            }
        }

        return num;
    }
}