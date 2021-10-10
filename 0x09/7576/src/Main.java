import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 시작점들은 queue에 넣어 동시에 bfs 동작
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[1]);
        int y = Integer.parseInt(xy[0]);
        int[][] board = new int[x][y];
        int[][] day = new int[x][y];
        Queue<Pair> startQ = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < x; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 1) {
                    startQ.offer(new Pair(i, j));
                    day[i][j] = 1;
                }
            }
        }

        while (!startQ.isEmpty()) {
            Pair cur = startQ.poll();
            int curX = cur.getX();
            int curY = cur.getY();

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];

                if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                    continue;
                }
                if (board[nextX][nextY] != 0 || day[nextX][nextY] >= 1) {
                    continue;
                }
                day[nextX][nextY] = day[cur.getX()][cur.getY()] + 1;

                startQ.offer(new Pair(nextX, nextY));
            }

        }


        int maxDay = -1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] != -1 && day[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                if (maxDay < day[i][j]) {
                    maxDay = day[i][j];
                }

            }
        }
        System.out.printf("%d", maxDay - 1);
    }
}


class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
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
