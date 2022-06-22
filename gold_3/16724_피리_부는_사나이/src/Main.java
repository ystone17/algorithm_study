import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int yLen, xLen, answer;
    static char[][] map;
    static int[][] visited;

    static Map<Character, int[]> dir = new HashMap<>();
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        dir.put('D', new int[]{1, 0});
        dir.put('U', new int[]{-1, 0});
        dir.put('R', new int[]{0, 1});
        dir.put('L', new int[]{0, -1});

        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new char[yLen][xLen];
        visited = new int[yLen][xLen];

        for (int i = 0; i < yLen; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int n = 1;
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if(visited[y][x] > 0) continue;
                visited[y][x] = n;
                q.add(new Pos(y, x));
                while (!q.isEmpty()) {
                    Pos cur = q.poll();

                    int[] yx = dir.get(map[cur.y][cur.x]);

                    int ny = cur.y + yx[0];
                    int nx = cur.x + yx[1];

                    if(visited[ny][nx] == n) {
                        answer++;
                        break;
                    }

                    if(visited[ny][nx] > 0 ) break;
                    visited[ny][nx] = n;
                    q.add(new Pos(ny, nx));
                }
                n++;
            }
        }
        System.out.println(answer);

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

