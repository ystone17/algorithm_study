import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int D = 0, U = 1, R = 2, L = 3;
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    static int yLen, xLen, res;
    static char[][] map;
    static int[][] check;
    static Map<Integer, Boolean> isEscape = new HashMap<>();
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new char[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            map[y] = br.readLine().toCharArray();
        }

        check = new int[yLen][xLen];

        int count = 1;
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (check[y][x] != 0) {
                    continue;
                }

                q.add(new Pos(y, x));

                while (!q.isEmpty()) {
                    var cur = q.poll();
                    if (cur.y < 0 || cur.y >= yLen || cur.x < 0 || cur.x >= xLen) {
                        isEscape.put(count, true);
                        break;
                    }
                    if (check[cur.y][cur.x] != 0) {
                        if (isEscape.get(check[cur.y][cur.x]) != null) {
                            isEscape.put(count, true);
                        }
                        break;
                    }
                    check[cur.y][cur.x] = count;

                    int ny = cur.y + dy[toDir(map[cur.y][cur.x])];
                    int nx = cur.x + dx[toDir(map[cur.y][cur.x])];

                    q.add(new Pos(ny, nx));
                }
                count++;
            }
        }

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (isEscape.get(check[y][x]) == null) {
                    continue;
                }

                res++;
            }
        }

        System.out.println(res);
    }

    static int toDir(char c) {
        switch (c) {
            case 'D':
                return D;
            case 'U':
                return U;
            case 'R':
                return R;
            case 'L':
                return L;
        }

        return -1;
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
