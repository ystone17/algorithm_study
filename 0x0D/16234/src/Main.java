import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, min, max;
    static int[][] country, visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static List<Integer> open = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        country = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = -1;
        boolean isOpen = true;
        while (isOpen) {
            res++;
            isOpen = false;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {

                    if (visited[y][x] == 1) continue;

                    for (int dir = 0; dir < 4; dir++) {
                        int qy = y + dy[dir];
                        int qx = x + dx[dir];

                        if (qy < 0 || qy >= n || qx < 0 || qx >= n) continue;
                        if (visited[qy][qx] == 1) continue;
                        int abs = Math.abs(country[y][x] - country[qy][qx]);
                        if (min > abs || max < abs) continue;

                        q.add(y * n + x);
                        visited[y][x] = 1;
                        open.add(y * n + x);
                        break;

                    }
                    int total = country[y][x];

                    while (!q.isEmpty()) {
                        int poll = q.poll();
                        int ny = poll / n;
                        int nx = poll % n;

                        for (int i = 0; i < 4; i++) {
                            int qy = ny + dy[i];
                            int qx = nx + dx[i];

                            if (qy < 0 || qy >= n || qx < 0 || qx >= n) continue;
                            if (visited[qy][qx] == 1) continue;
                            int abs = Math.abs(country[ny][nx] - country[qy][qx]);
                            if (min > abs || max < abs) continue;

                            isOpen = true;
                            q.add(qy * n + qx);
                            visited[qy][qx] = 1;
                            open.add(qy * n + qx);
                            total += country[qy][qx];
                        }
                    }

                    for (int o : open) {
                        country[o / n][o % n] = total / open.size();
                    }
                    open = new ArrayList<>();
                }
            }
            visited = new int[n][n];
        }

        System.out.println(res);


    }
}
