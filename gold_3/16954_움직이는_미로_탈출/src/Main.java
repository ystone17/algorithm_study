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

    static char[][] map = new char[8][8];
    static int wallCnt, size;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1, 0};

    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                map[i][j] = row[j];
                if (map[i][j] == '#') {
                    wallCnt++;
                }
            }
        }

        q.add(new Pos(7, 0));

        while (!q.isEmpty()) {
            size = q.size();

            for (int i = 0; i < size; i++) {
                Pos cur = q.poll();

                if(map[cur.y][cur.x] == '#') continue;
                if(wallCnt == 0 || cur.y == 0 && cur.x == 7) {
                    System.out.println(1);
                    return;
                }

                for (int j = 0; j < 9; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];

                    if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8) continue;
                    if(map[ny][nx] == '#') continue;

                    q.add(new Pos(ny, nx));
                }
            }
            moveWall();
        }
        System.out.println(0);

    }

    static void moveWall() {
        for (int i = 0; i < 8; i++) {
            if (map[7][i] == '#') wallCnt--;
        }

        for (int i = 6; i >= 0; i--) {
            System.arraycopy(map[i], 0, map[i + 1], 0, 8);
        }

        for (int i = 0; i < 8; i++) {
            map[0][i] = '.';
        }
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
