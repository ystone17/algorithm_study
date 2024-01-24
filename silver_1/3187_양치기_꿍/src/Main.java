import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] map;
    static boolean[][] visited;
    static int yLen, xLen, resK, resV;
    static List<Record> records = new ArrayList<>();
    static Queue<Pos> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new char[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            map[y] = br.readLine().toCharArray();
        }

        visited = new boolean[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (visited[y][x]) {
                    continue;
                }

                visited[y][x] = true;
                q.clear();
                q.add(new Pos(y, x));
                int kCnt = 0;
                int vCnt = 0;

                while (!q.isEmpty()) {
                    Pos cur = q.poll();
                    if (map[cur.y][cur.x] == 'v') {
                        vCnt++;
                    } else if (map[cur.y][cur.x] == 'k') {
                        kCnt++;
                    }

                    for (int dir = 0; dir < 4; dir++) {
                        int ny = cur.y + dy[dir];
                        int nx = cur.x + dx[dir];

                        if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) {
                            continue;
                        }
                        if (map[ny][nx] == '#') {
                            continue;
                        }
                        if (visited[ny][nx]) {
                            continue;
                        }

                        visited[ny][nx] = true;
                        q.add(new Pos(ny, nx));
                    }
                }
                records.add(new Record(kCnt, vCnt));
            }
        }


        for (Record record : records) {
            if (record.kCnt > record.vCnt) {
                resK += record.kCnt;
            } else {
                resV += record.vCnt;
            }
        }
        System.out.printf("%d %d", resK, resV);
    }

    private static class Record {
        int kCnt;
        int vCnt;

        public Record(int kCnt, int vCnt) {
            this.kCnt = kCnt;
            this.vCnt = vCnt;
        }
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
