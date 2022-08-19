import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Set<Integer> visited = new HashSet<>();
    static Queue<Table> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        Table table = new Table();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                table.t[i][j] = Integer.parseInt(st.nextToken());
                if (table.t[i][j] == 0) {
                    table.y = i;
                    table.x = j;
                }
            }
        }

        int count = 0;
        int size, ny, nx;
        q.add(table);
        setVisited(table.t);

        while (!q.isEmpty()) {
            size = q.size();

            for (int s = 0; s < size; s++) {
                Table cur = q.poll();

                if (cur.y == 2 && cur.x == 2 && isEnd(cur)) {
                    System.out.println(count);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    ny = cur.y + dy[i];
                    nx = cur.x + dx[i];
                    if (ny < 0 || ny >= 3 || nx < 0 || nx >= 3) continue;

                    int[][] temp = nT(cur, ny, nx);
                    if (!setVisited(temp)) continue;

                    q.add(new Table(temp, ny, nx));
                }
            }
            count++;
        }
        System.out.println(-1);
    }

    static int[][] nT(Table cur, int ny, int nx) {
        int[][] res = new int[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                res[y][x] = cur.t[y][x];
            }
        }

        res[cur.y][cur.x] = cur.t[ny][nx];
        res[ny][nx] = 0;

        return res;
    }

    static boolean setVisited(int[][] table) {
        int temp = 0;
        int digit = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp += table[i][j] * digit;
                digit *= 10;
            }
        }

        if (visited.contains(temp)) {
            return false;
        } else {
            visited.add(temp);
            return true;
        }
    }

    static boolean isEnd(Table table) {
        int num = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 2 && j == 2) break;
                if (table.t[i][j] != num) {
                    return false;
                }
                num++;
            }
        }

        return true;
    }

    static class Table {
        int[][] t = new int[3][3];
        int y;
        int x;

        public Table() {
        }

        public Table(int[][] t, int y, int x) {
            this.t = t;
            this.y = y;
            this.x = x;
        }
    }
}
