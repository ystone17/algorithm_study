import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int y, x;
    static char[][] map;
    static int[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Coordinate> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new char[y][x];
        for (int i = 0; i < y; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int res = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] != 'L') continue;

                visited = new int[y][x];
                q = new LinkedList<>();
                q.add(new Coordinate(i, j));
                visited[i][j] = 1;
                int count = -1;
                while (!q.isEmpty()) {
                    int size = q.size();
                    count++;

                    for (int k = 0; k < size; k++) {
                        Coordinate curCo = q.poll();

                        for (int p = 0; p < 4; p++) {
                            int ny = curCo.y + dy[p];
                            int nx = curCo.x + dx[p];

                            if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                            if (visited[ny][nx] == 1 || map[ny][nx] == 'W') continue;

                            visited[ny][nx] = 1;
                            q.add(new Coordinate(ny, nx));
                        }
                    }
                }

                res = Math.max(res, count);


            }
        }

        System.out.println(res);

    }

    static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
