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


    static int yLength, xLength;
    static int[][] visited, map;

    static Queue<Pos> q = new LinkedList<>();

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLength = Integer.parseInt(st.nextToken());
        xLength = Integer.parseInt(st.nextToken());

        map = new int[yLength][xLength];
        visited = new int[yLength][xLength];

        for (int y = 0; y < yLength; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xLength; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                visited[y][x] = -1;

                if (map[y][x] == 2) {
                    q.add(new Pos(y, x));
                    visited[y][x] = 0;
                }

                if (map[y][x] == 0) {
                    visited[y][x] = 0;
                }
            }
        }

        int cnt = 1;
        while (!(q.isEmpty())) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pos cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= yLength || nx < 0 || nx >= xLength) continue;
                    if (map[ny][nx] == 0) continue;
                    if (visited[ny][nx] != -1) continue;
                    q.add(new Pos(ny, nx));
                    visited[ny][nx] = cnt;
                }
            }

            cnt++;
        }

        for (int[] row : visited) {
            for (int i : row) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
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
