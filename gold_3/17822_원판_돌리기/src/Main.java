import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int circleNum, digitNum, tc;
    static int x, d, k;
    static int[][] circles;
    static Deque<Integer> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        circleNum = Integer.parseInt(st.nextToken());
        digitNum = Integer.parseInt(st.nextToken());
        tc = Integer.parseInt(st.nextToken());

        circles = new int[circleNum][digitNum];

        for (int i = 0; i < circleNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < digitNum; j++) {
                circles[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int mul = 1;
            while (x * mul <= circleNum){
                int i = x * mul;

                for (int c : circles[i - 1]) {
                    q.add(c);
                }

                if (d == 0) {
                    for (int j = 0; j < k; j++) {
                        q.addFirst(q.pollLast());
                    }
                } else {
                    for (int j = 0; j < k; j++) {
                        q.addLast(q.pollFirst());
                    }
                }

                for (int j = 0; j < circles[i-1].length; j++) {
                    circles[i - 1][j] = q.pollFirst();
                }

                mul++;
            }
            bfs();
        }

        int res = 0;
        for (int[] circle : circles) {
            for (int i : circle) {
                if (i == Integer.MIN_VALUE) continue;
                res += i;
            }
        }

        System.out.println(res);
    }


    static void bfs() {
        visited = new int[circleNum][digitNum];
        Queue<Pos> q = new LinkedList<>();

        boolean avg = false;
        int total = 0;
        int cnt = 0;
        for (int i = 0; i < circleNum; i++) {
            for (int j = 0; j < digitNum; j++) {
                if (circles[i][j] == Integer.MIN_VALUE) continue;
                total += circles[i][j];
                cnt++;
                if (visited[i][j] == 1) continue;

                visited[i][j] = 1;
                int num = circles[i][j];
                boolean find = false;

                q.add(new Pos(i, j));
                while (!q.isEmpty()) {
                    Pos cur = q.poll();

                    for (int l = 0; l < 4; l++) {
                        int ny = cur.y + dy[l];
                        int nx = cur.x + dx[l];
                        nx = (nx + digitNum) % digitNum;

                        if (ny < 0 || ny >= circleNum) continue;
                        if (visited[ny][nx] == 1 || circles[ny][nx] != num) continue;
                        visited[ny][nx] = 1;
                        q.add(new Pos(ny, nx));
                        find = true;
                        avg = true;
                    }
                    if (find) {
                        circles[cur.y][cur.x] = Integer.MIN_VALUE;
                    } else {
                        break;
                    }
                }

            }
        }

        if (!avg) {
            for (int i = 0; i < circles.length; i++) {
                for (int j = 0; j < circles[i].length; j++) {
                    if (circles[i][j] == Integer.MIN_VALUE) continue;
                    if (circles[i][j] > (float)total / cnt) {
                        circles[i][j]--;
                    } else if (circles[i][j] < (float)total / cnt) {
                        circles[i][j]++;
                    }
                }
            }
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
