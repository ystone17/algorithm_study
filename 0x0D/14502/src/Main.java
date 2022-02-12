import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map, nMap;
    static int[] wall = new int[3];
    static List<Integer> zeros = new ArrayList<>();
    static List<Integer> virus = new ArrayList<>();
    static int ySize, xSize;
    static Queue<Integer> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        map = new int[ySize][xSize];
        nMap = new int[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xSize; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 0) zeros.add(y * xSize + x);
                else if (map[y][x] == 2) virus.add(y * xSize + x);
            }
        }

        point(0, 0, ySize * xSize);
        System.out.println(res);
    }

    static void point(int num, int start, int end) {
        if (num == 3) {
            // gogogo

            for (int y = 0; y < map.length; y++) {
                System.arraycopy(map[y], 0, nMap[y], 0, map[y].length);
            }

            for (int w : wall) {
                nMap[w / xSize][w % xSize] = 1;
            }

            //bfs
            for (int v : virus) {
                q.offer(v);
            }

            while (!q.isEmpty()) {
                int n = q.poll();
                int y = n / xSize;
                int x = n % xSize;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || ny >= ySize || nx < 0 || nx >= xSize || nMap[ny][nx] != 0) continue;

                    nMap[ny][nx] = 2;
                    q.offer(ny * xSize + nx);
                }

            }

            //res 저장
            int r = 0;
            for (int[] row : nMap) {
                for (int block : row) {
                    if (block == 0) r++;
                }
            }

            res = Math.max(res, r);
            return;
        }

        for (int i = start; i < end; i++) {
            if (map[i / xSize][i % xSize] != 0) continue;
            wall[num] = i;
            point(num + 1, i + 1, end);
        }

    }
}
