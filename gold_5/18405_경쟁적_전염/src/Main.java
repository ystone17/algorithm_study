import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static PriorityQueue<Pos> pq = new PriorityQueue<>();
    static Queue<Pos> q = new LinkedList<>();
    static int n, k;
    static int[][] map;
    static int s, y, x;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) pq.add(new Pos(i, j, map[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < s; i++) {
            if (pq.isEmpty()) break;

            int size = pq.size();
            for (int k = 0; k < size; k++) {
                Pos cur = pq.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                    if (map[ny][nx] != 0) continue;

                    map[ny][nx] = map[cur.y][cur.x];
                    q.add(new Pos(ny, nx, map[cur.y][cur.x]));
                }
            }
            while (!q.isEmpty()) pq.add(q.poll());
        }

        System.out.println(map[y-1][x-1]);

    }

    static class Pos implements Comparable<Pos> {
        int y;
        int x;
        int virus;

        public Pos(int y, int x, int virus) {
            this.y = y;
            this.x = x;
            this.virus = virus;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(virus, o.virus);
        }
    }
}
