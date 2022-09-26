import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int width, height;
    static int[][] map, roomNumArr;

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static Queue<Pos> q = new LinkedList<>();
    static List<Integer> roomSizeList = new ArrayList<>();
    static List<Set<Integer>> neighbor = new ArrayList<>();

    static int a1, a2, a3;

    static final int binary = 2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        roomNumArr = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roomSizeList.add(0);

        // 방 구하기
        int roomNum = 1;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (roomNumArr[y][x] != 0) continue;
                roomSizeList.add(bfs(y, x, roomNum++));
            }
        }

        // 방 관계 구하기
        for (int i = 0; i < roomNum; i++) {
            neighbor.add(new HashSet<>());
        }

        int ny, nx;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (int d = 0; d < 4; d++) {
                    ny = y + dy[d];
                    nx = x + dx[d];
                    if (ny < 0 || ny >= height || nx < 0 || nx >= width) continue;
                    if (roomNumArr[y][x] == roomNumArr[ny][nx]) continue;
                    neighbor.get(roomNumArr[y][x]).add(roomNumArr[ny][nx]);
                }
            }
        }

        a1 = roomNum - 1;
        for (int i = 1; i < neighbor.size(); i++) {
            a2 = Math.max(a2, roomSizeList.get(i));
            for (Integer n : neighbor.get(i)) {
                a3 = Math.max(a3, roomSizeList.get(i) + roomSizeList.get(n));
            }
        }

        sb.append(a1).append("\n").append(a2).append("\n").append(a3).append("\n");
        System.out.println(sb);
    }

    static int bfs(int y, int x, int roomNum) {
        q.clear();

        q.add(new Pos(y, x));
        roomNumArr[y][x] = roomNum;

        int dir, ny, nx, size = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            dir = map[cur.y][cur.x] * 2;

            for (int i = 0; i < 4; i++) {
                dir /= 2;
                if (dir % 2 == 0) {
                    ny = cur.y + dy[i];
                    nx = cur.x + dx[i];

                    if (ny < 0 || ny >= height || nx < 0 || nx >= width) continue;
                    if (roomNumArr[ny][nx] != 0) continue;

                    roomNumArr[ny][nx] = roomNum;
                    q.add(new Pos(ny, nx));
                    size++;
                }

            }
        }

        return size;
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
