import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    static int[][] visited;

    static int n;
    static int sy, sx, ey, ex;

    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());

        if (sy == ey && sx == ex) {
            System.out.println(0);
            return;
        }

        visited = new int[n][n];
        visited[sy][sx] = 0;

        q.add(new int[]{sy, sx});

        int cnt = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();

                for (int d = 0; d < dy.length; d++) {
                    int ny = poll[0] + dy[d];
                    int nx = poll[1] + dx[d];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                        continue;
                    }

                    if (ny == ey && nx == ex) {
                        System.out.println(cnt);
                        return;
                    }

                    if (visited[ny][nx] == 1) {
                        continue;
                    }

                    visited[ny][nx] = 1;
                    q.add(new int[]{ny, nx});
                }
            }
            cnt++;
        }

        System.out.println(-1);
    }
}
