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

    static int y, x, k;
    static char[][] map;
    static int[][][] visited;
    static Queue<Node> q = new LinkedList<>();
    static boolean day = true;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[y + 1][x + 1];
        visited = new int[y + 1][x + 1][k + 1];

        for (int i = 0; i < y; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                map[i + 1][j + 1] = row[j];
            }
        }

        q.add(new Node(1, 1, 0, 1));
        visited[1][1][0] = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();

                if (cur.y == y && cur.x == x) {
                    System.out.println(cur.count);
                    return;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 1 || ny > y || nx < 1 || nx > x) {
                        continue;
                    }

                    if (map[ny][nx] == '0') {
                        if (visited[ny][nx][cur.k] == 0) {
                            visited[ny][nx][cur.k] = 1;
                            q.add(new Node(ny, nx, cur.k, cur.count + 1));
                        }
                    } else {
                        if (day && cur.k < k && visited[ny][nx][cur.k + 1] == 0) {
                            visited[ny][nx][cur.k + 1] = 1;
                            q.add(new Node(ny, nx, cur.k + 1, cur.count + 1));
                        }
                    }
                }

                if (!day) {
                    q.add(new Node(cur.y, cur.x, cur.k, cur.count + 1));
                }
            }

            day = !day;
        }

        System.out.println(-1);
    }

    static class Node {
        int y;
        int x;
        int k;
        int count;

        public Node(int y, int x, int k, int count) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.count = count;
        }
    }
}
