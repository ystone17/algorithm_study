import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int y, x, n, res;
    static boolean[][] map, visited;

    static Queue<int[]> q;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new boolean[y + 1][x + 1];
        visited = new boolean[y + 1][x + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ty = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());

            map[ty][tx] = true;
        }

        for (int a = 1; a <= y; a++) {
            for (int b = 1; b <= x; b++) {
                if (visited[a][b]) continue;
                if (!map[a][b]) continue;

                int cnt = 0;

                q = new LinkedList<>();
                q.add(new int[]{a, b});
                visited[a][b] = true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    cnt++;

                    for (int i = 0; i < 4; i++) {
                        int ny = cur[0] + dy[i];
                        int nx = cur[1] + dx[i];

                        if(ny < 1 || ny > y) continue;
                        if(nx < 1 || nx > x) continue;
                        if(visited[ny][nx]) continue;
                        if(!map[ny][nx]) continue;

                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }

                res = Math.max(res, cnt);
            }
        }

        System.out.println(res);

    }
}
