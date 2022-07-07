import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int size, idx = 1;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] map, dist;
    static Queue<Pos> q;

    public static void main(String[] args) throws IOException {

        while (true) {
            size = Integer.parseInt(br.readLine());
            if (size == 0) break;

            map = new int[size][size];
            dist = new int[size][size];
            q = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            q.add(new Pos(0, 0, map[0][0]));
            dist[0][0] = map[0][0];

            while (!q.isEmpty()) {
                Pos cur = q.poll();

                if (dist[cur.y][cur.x] < cur.value) continue;

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= size || nx < 0 || nx >= size) continue;
                    if (cur.value + map[ny][nx] >= dist[ny][nx]) continue;
                    dist[ny][nx] = cur.value + map[ny][nx];
                    q.add(new Pos(ny, nx, dist[ny][nx]));
                }
            }

            sb.append(String.format("Problem %d: %d\n", idx++, dist[size - 1][size - 1]));
        }



        System.out.println(sb);

    }

    static class Pos {
        int y;
        int x;
        int value;

        public Pos(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }

}
