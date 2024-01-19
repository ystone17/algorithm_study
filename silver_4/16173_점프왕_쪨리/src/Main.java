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

    static int n;
    static int[][] map = new int[3][3];
    static boolean[][] visited = new boolean[3][3];
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new Pos(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.y == n - 1 && cur.x == n - 1) {
                System.out.println("HaruHaru");
                return;
            }

            int dist = map[cur.y][cur.x];

            if (cur.y + dist < n && !visited[cur.y + dist][cur.x]) {
                visited[cur.y + dist][cur.x] = true;
                q.add(new Pos(cur.y + dist, cur.x));
            }

            if (cur.x + dist < n && !visited[cur.y][cur.x + dist]) {
                visited[cur.y][cur.x + dist] = true;
                q.add(new Pos(cur.y, cur.x + dist));
            }
        }

        System.out.println("Hing");
    }

    public static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
