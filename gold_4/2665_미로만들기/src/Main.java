import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int size;
    static int[][] map;

    static Queue<Pos> q;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int[][] graph;
    static int[][][] visited;
    static Queue<Pos2> q2;

    static int[] dist, finish;

    public static void main(String[] args) throws IOException {
        // input
        size = Integer.parseInt(br.readLine());

        map = new int[size][size];

        for (int y = 0; y < size; y++) {
            char[] row = br.readLine().toCharArray();
            for (int x = 0; x < size; x++) {
                map[y][x] = row[x] == '0' ? 0 : -1;
            }
        }


        // bfs
        int nodeNum = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (map[y][x] != -1) continue;
                nodeNum++;

                q = new LinkedList<>();
                q.add(new Pos(y, x));
                map[y][x] = nodeNum;

                while (!q.isEmpty()) {
                    Pos cur = q.poll();

                    for (int i = 0; i < 4; i++) {
                        int ny = cur.y + dy[i];
                        int nx = cur.x + dx[i];

                        if (ny < 0 || ny >= size || nx < 0 || nx >= size) continue;
                        if (map[ny][nx] != -1) continue;

                        map[ny][nx] = nodeNum;
                        q.add(new Pos(ny, nx));
                    }
                }

            }
        }

        graph = new int[nodeNum + 1][nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            Arrays.fill(graph[i], 123_456_789);
        }
        visited = new int[nodeNum + 1][size][size];

        // second bfs
        q2 = new LinkedList<>();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (map[y][x] == 0) continue;
                if (isEdge(y, x)) {
                    q2.add(new Pos2(y, x, map[y][x], 0));
                    visited[map[y][x]][y][x] = 1;
                }
            }
        }

        while (!q2.isEmpty()) {
            Pos2 cur = q2.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= size || nx < 0 || nx >= size) continue;
                if (visited[cur.originNum][ny][nx] == 1) continue;
                if (map[ny][nx] == cur.originNum) continue;

                if (map[ny][nx] != 0) {
                    graph[cur.originNum][map[ny][nx]] = Math.min(graph[cur.originNum][map[ny][nx]], cur.cnt);
                    continue;
                }

                if (map[ny][nx] == 0) {
                    q2.add(new Pos2(ny, nx, cur.originNum, cur.cnt + 1));
                    visited[cur.originNum][ny][nx] = 1;
                }
            }
        }

        // dijkstra
        dist = new int[nodeNum + 1];
        Arrays.fill(dist, 123_456_789);
        dist[1] = 0;
        finish = new int[nodeNum + 1];

        for (int i = 0; i < nodeNum - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = 1;
            for (int j = 1; j < dist.length; j++) {
                if(finish[j] == 1) continue;
                if(min > dist[j]) {
                    min = dist[j];
                    minIdx = j;
                }
            }

            finish[minIdx] = 1;

            for (int j = 1; j < graph[minIdx].length; j++) {
                if(dist[j] > dist[minIdx] + graph[minIdx][j]) {
                    dist[j] = dist[minIdx] + graph[minIdx][j];
                }
            }
        }

        System.out.println(dist[map[size-1][size-1]]);
    }

    private static boolean isEdge(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= size || nx < 0 || nx >= size) continue;
            if (map[ny][nx] == 0) return true;
        }

        return false;
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Pos2 {
        int y;
        int x;
        int originNum;
        int cnt;

        public Pos2(int y, int x, int originNum, int cnt) {
            this.y = y;
            this.x = x;
            this.originNum = originNum;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Pos2{" +
                    "y=" + y +
                    ", x=" + x +
                    ", originNum=" + originNum +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
