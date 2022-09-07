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

    static int h, w, sheep, wolf;
    static char[][] map;
    static boolean[][] visited;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if(visited[y][x]) continue;
                bfs(y, x);
            }
        }

        sb.append(sheep).append(" ").append(wolf);
        System.out.println(sb);
    }

    static void bfs(int y, int x) {
        int bSheep = 0, bWolf = 0, ny, nx;
        q.clear();

        q.add(new Pos(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if(map[cur.y][cur.x] == 'o'){
                bSheep++;
            } else if(map[cur.y][cur.x] == 'v'){
                bWolf++;
            }

            for (int i = 0; i < 4; i++) {
                ny = cur.y + dy[i];
                nx = cur.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if(map[ny][nx] == '#') continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(new Pos(ny, nx));
            }
        }

        if( bSheep > bWolf ){
            sheep += bSheep;
        } else{
            wolf += bWolf;
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
