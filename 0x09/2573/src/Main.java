import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] nextPos = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    static int x;
    static int y;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int res = 0;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        board = new int[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {

            int iceNum = getIceNum(board);
            if (iceNum >= 2) {
                break;
            } else if (iceNum == 0) {
                res = 0;
                break;
            }
            res++;
        }
        System.out.println(res);
    }

    static int getIceNum(int[][] board) {
        int[][] visited = new int[x][y];
        int iceNum = 0;
        Queue<xy> Q = new LinkedList<>();

        for (int x = 0; x < Main.x; x++) {
            for (int y = 0; y < Main.y; y++) {
                if (visited[x][y] == 1 || board[x][y] == 0) {
                    continue;
                }

                iceNum++;
                visited[x][y] = 1;
                Q.offer(new xy(x, y));
                while (!Q.isEmpty()) {
                    xy cur = Q.poll();
                    int curX = cur.getX();
                    int curY = cur.getY();
                    for (int i = 0; i < 4; i++) {
                        int nextX = curX + nextPos[i][0];
                        int nextY = curY + nextPos[i][1];

                        if (nextX < 0 || nextX >= Main.x || nextY < 0 || nextY >= Main.y) {
                            continue;
                        }

                        if (visited[nextX][nextY] == 1) {
                            continue;
                        }

                        if (board[nextX][nextY] == 0) {
                            if (board[curX][curY] != 0)
                                board[curX][curY]--;
                            continue;
                        }

                        xy next = new xy(nextX, nextY);
                        visited[nextX][nextY] = 1;
                        Q.offer(next);
                    }
                }


            }
        }
        return iceNum;
    }


    static void printBoard(int[][] board) {
        for (int[] line : board) {
            for (int ele : line) {
                System.out.printf("%2d ", ele);
            }
            System.out.println();
        }
    }
}

class xy {
    private int x;
    private int y;

    public xy(int x, int y) {
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