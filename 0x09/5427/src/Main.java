import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static StringTokenizer st;
    static BufferedReader br;
    static int[][] nextPos = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int escapeTime = getEscapeTime();
            if (escapeTime == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(escapeTime);
            }
        }

    }

    private static int getEscapeTime() throws IOException {
        int res = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        board = new char[x][y];
        int[][] fireTime = new int[x][y];
        int[][] sangTime = new int[x][y];
        Queue<XY> q = new LinkedList<>();
        for (char[] line : board) {
            System.arraycopy(br.readLine().toCharArray(), 0, line, 0, line.length);
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] != '*') {
                    continue;
                }
                fireTime[i][j] = 1;
                q.offer(new XY(i, j));
            }
        }

        while (!q.isEmpty()) {
            XY cur = q.poll();
            int curX = cur.getX();
            int curY = cur.getY();

            for (int k = 0; k < 4; k++) {
                int nextX = curX + nextPos[k][0];
                int nextY = curY + nextPos[k][1];

                if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                    continue;
                }

                if (board[nextX][nextY] == '#') {
                    continue;
                }

                if (fireTime[nextX][nextY] >= 1) {
                    continue;
                }


                XY next = new XY(nextX, nextY);
                q.offer(next);
                fireTime[nextX][nextY] = fireTime[curX][curY] + 1;
            }

        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == '@') {
                    sangTime[i][j] = 1;
                    q.offer(new XY(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            XY cur = q.poll();
            int curX = cur.getX();
            int curY = cur.getY();

            for (int k = 0; k < 4; k++) {
                int nextX = curX + nextPos[k][0];
                int nextY = curY + nextPos[k][1];

                if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                    if (res > sangTime[curX][curY]) res = sangTime[curX][curY];
                    break;
                }

                if (board[nextX][nextY] == '#') {
                    continue;
                }

                if (sangTime[nextX][nextY] >= 1) {
                    continue;
                }


                if (fireTime[nextX][nextY] != 0 && sangTime[curX][curY] + 1 >= fireTime[nextX][nextY]) {
                    continue;
                }


                XY next = new XY(nextX, nextY);
                q.offer(next);
                sangTime[nextX][nextY] = sangTime[curX][curY] + 1;
            }

        }


        return res;
    }

    private static void printBoard() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.printf("%2c", aChar);
            }
            System.out.println();
        }
        System.out.println();
    }
}

class XY {
    private int x;
    private int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}