import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int y, x;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] visited;
    static char[][] map;
    static Queue<Pos> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new char[y][x];
        visited = new int[y][x];

        for (int i = 0; i < y; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                map[i][j] = row[j];
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        q.add(new Pos(0, 0));
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;

                int broken = visited[cur.y][cur.x];
                if (map[ny][nx] == '1') {
                    broken++;
                }
                if( visited[ny][nx] <= broken) continue;
                visited[ny][nx] = broken;
                q.add(new Pos(ny, nx));
            }
        }

        System.out.println(visited[y - 1][x - 1]);
    }


    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
