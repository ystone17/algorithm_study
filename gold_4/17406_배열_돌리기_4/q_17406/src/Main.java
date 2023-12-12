import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k, res = Integer.MAX_VALUE;
    static int[][] map, op;
    static int[] rotateSeq, visited;

    static Deque<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        op = new int[k][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            op[i][0] = Integer.parseInt(st.nextToken());
            op[i][1] = Integer.parseInt(st.nextToken());
            op[i][2] = Integer.parseInt(st.nextToken());
        }

        rotateSeq = new int[k];
        visited = new int[k];
        simulate(0);
        System.out.println(res);
    }

    private static void simulate(int count) {
        if (count >= k) {
            res = Math.min(res, getMin());
        }

        for (int i = 0; i < k; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            rotateSeq[count] = i;
            simulate(count + 1);
            visited[i] = 0;
        }
    }

    private static int getMin() {
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < rotateSeq.length; i++) {
            rotate(copyMap, i);
        }

        int min = Integer.MAX_VALUE;
        int total;
        for (int i = 0; i < n; i++) {
            total = 0;
            for (int j = 0; j < m; j++) {
                total += copyMap[i][j];
            }

            min = Math.min(min, total);
        }

        return min;
    }

    private static void rotate(int[][] copyMap, int i) {
        var seq = op[rotateSeq[i]];

        int startY = seq[0] - seq[2] - 1;
        int startX = seq[1] - seq[2] - 1;

        int endY = seq[0] + seq[2] - 1;
        int endX = seq[1] + seq[2] - 1;

        int y;
        int x;

        while (startY != endY) {
            q.clear();
            y = startY;
            x = startX;

            while (x < endX) {
                q.add(copyMap[y][x]);
                x++;
            }

            while (y < endY) {
                q.add(copyMap[y][x]);
                y++;
            }


            while (x > startX) {
                q.add(copyMap[y][x]);
                x--;
            }


            while (y > startY) {
                q.add(copyMap[y][x]);
                y--;
            }

            q.addFirst(q.pollLast());
            while (!q.isEmpty()) {
                while (x < endX) {
                    copyMap[y][x] = q.pollFirst();
                    x++;
                }

                while (y < endY) {
                    copyMap[y][x] = q.pollFirst();
                    y++;
                }


                while (x > startX) {
                    copyMap[y][x] = q.pollFirst();
                    x--;
                }

                while (y > startY) {
                    copyMap[y][x] = q.pollFirst();
                    y--;
                }
            }

            startY++;
            startX++;

            endY--;
            endX--;
        }
    }
}
