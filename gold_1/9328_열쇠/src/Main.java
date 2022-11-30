import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int h, w;
    static char[][] map;
    static int[] keys = new int[26];
    static int[][] visited;
    static Queue<Pos> q = new LinkedList<>();
    static List<List<Pos>> gateList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            run();
        }
        System.out.println(sb);
    }

    static void run() throws IOException {
        init();
        int res = bfs();
        sb.append(res).append("\n");
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h + 2][w + 2];
        keys = new int[26];
        visited = new int[h + 2][w + 2];
        q = new LinkedList<>();
        gateList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            gateList.add(new ArrayList<>());
        }

        for (int i = 1; i <= h; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 1; j <= w; j++) {
                map[i][j] = row[j - 1];
            }
        }

        String keyString = br.readLine();
        if (keyString.equals("0")) return;

        for (char c : keyString.toCharArray()) {
            keys[c - 'a'] = 1;
        }
    }

    private static int bfs() {
        int paper = 0;

        Pos start = new Pos(0, 0);

        q.add(start);
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny > h + 1 || nx < 0 || nx > w + 1) continue;
                if (visited[ny][nx] == 1) continue;
                if (map[ny][nx] == '*') continue;
                if (0 <= map[ny][nx] - 'A' && map[ny][nx] - 'A' < 26) {
                    if (keys[map[ny][nx] - 'A'] == 0) {
                        gateList.get(map[ny][nx] - 'A').add(new Pos(ny, nx));
                        continue;
                    }
                }

                if (0 <= map[ny][nx] - 'a' && map[ny][nx] - 'a' < 26) {
                    keys[map[ny][nx] - 'a'] = 1;
                    q.addAll(gateList.get(map[ny][nx] - 'a'));
                }

                if (map[ny][nx] == '$') paper++;

                visited[ny][nx] = 1;
                q.add(new Pos(ny, nx));
            }
        }

        return paper;
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
