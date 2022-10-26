import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int yLen, xLen;
    static int[][] map;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Pos> q = new LinkedList<>();
    static boolean[][] visited;
    static final int base = 10;
    static int islandNum = base;

    static int[] parent;

    static int[][] graph;

    static PriorityQueue<Pos> pq = new PriorityQueue<>();

    static int res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new int[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬을 먼저 찾아야겠다
        visited = new boolean[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (visited[y][x] || map[y][x] == 0) continue;
                q.add(new Pos(y, x));
                visited[y][x] = true;
                map[y][x] = islandNum;
                while (!q.isEmpty()) {
                    Pos cur = q.poll();

                    for (int i = 0; i < 4; i++) {
                        int ny = cur.y + dy[i];
                        int nx = cur.x + dx[i];

                        if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) continue;
                        if (map[ny][nx] == 0 || visited[ny][nx]) continue;
                        map[ny][nx] = islandNum;
                        visited[ny][nx] = true;
                        q.add(new Pos(ny, nx));
                    }
                }
                islandNum++;
            }
        }

        graph = new int[islandNum - base][islandNum - base];
        for (int[] ints : graph) {
            Arrays.fill(ints, 100);
        }

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] == 0) continue;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) continue;
                    if (map[ny][nx] != 0) continue;

                    int len = 0;
                    while (true) {
                        if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) break;
                        if (map[ny][nx] != 0) {
                            if (len > 1) {
                                graph[map[y][x] - base][map[ny][nx] - base] = Math.min(graph[map[y][x] - base][map[ny][nx] - base], len);
                            }
                            break;
                        }
                        ny += dy[i];
                        nx += dx[i];
                        len++;
                    }
                }
            }
        }

        parent = new int[islandNum - base];
        Arrays.fill(parent, -1);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != 100) {
                    pq.add(new Pos(i, j, graph[i][j]));
                }
            }
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            Pos poll = pq.poll();

            if (find(poll.y) == find(poll.x)) continue;

            union(poll.y, poll.x);
            res += poll.len;
            cnt++;
        }

        if (cnt < islandNum - base - 1) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }


    static int find(int a) {
        if (parent[a] < 0) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (a < b) {
            parent[a] += parent[b];
            parent[b] = a;
        } else {
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    private static class Pos implements Comparable<Pos> {
        int y;
        int x;
        int len;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Pos(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(len, o.len);
        }
    }
}
