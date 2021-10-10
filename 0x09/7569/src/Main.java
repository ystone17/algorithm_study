import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 시작점들은 queue에 넣어 동시에 bfs 동작
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mnh = br.readLine().split(" ");
        int n = Integer.parseInt(mnh[1]);
        int m = Integer.parseInt(mnh[0]);
        int h = Integer.parseInt(mnh[2]);
        int[][][] board = new int[h][n][m];
        int[][][] day = new int[h][n][m];

        Queue<Pair> q = new LinkedList<>();
        int[] dh = {0, 0, 0, 0, 1, -1};
        int[] dn = {1, 0, -1, 0, 0, 0};
        int[] dm = {0, 1, 0, -1, 0, 0};


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(line[k]);
                    if (board[i][j][k] == 1) {
                        day[i][j][k] = 1;
                        q.offer(new Pair(i, j, k));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curH = cur.getH();
            int curN = cur.getN();
            int curM = cur.getM();

            for (int k = 0; k < 6; k++) {
                int nextH = curH + dh[k];
                int nextN = curN + dn[k];
                int nextM = curM + dm[k];
                if (nextN < 0 || nextN >= n || nextM < 0 || nextM >= m || nextH < 0 || nextH >= h) {
                    continue;
                }
                if (board[nextH][nextN][nextM] != 0 || day[nextH][nextN][nextM] >= 1) {
                    continue;
                }

                day[nextH][nextN][nextM] = day[curH][curN][curM] + 1;
                q.offer(new Pair(nextH, nextN, nextM));
            }
        }




        int maxDay = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] != -1 && day[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    if (maxDay < day[i][j][k]) {
                        maxDay = day[i][j][k];
                    }
                }

            }
        }
        System.out.printf("%d", maxDay - 1);
    }
}


class Pair {
    private int h;
    private int n;
    private int m;


    public Pair(int h, int n, int m) {
        this.h = h;
        this.n = n;
        this.m = m;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getH() {
        return h;
    }
}
