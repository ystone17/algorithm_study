import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        int[][] map = new int[5][5];
        int[][] map = new int[1000][1000];
        int[][] nextPos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//        int[][] distance = new int[5][5];
        int[][] distance = new int[1000][1000];
        Queue<xy> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int x = 0; x < n; x++) {
            String[] mapLine = br.readLine().split("");
            for (int y = 0; y < m; y++) {
                map[x][y] = Integer.parseInt(mapLine[y]);
            }
        }

        q.offer(new xy(0, 0, false));
        distance[0][0] = 1;
        while (!q.isEmpty()) {
            xy cur = q.poll();
            int curX = cur.getX();
            int curY = cur.getY();
            boolean curIsBreak = cur.isBreak();
            for (int i = 0; i < 4; i++) {
                int nextX = curX + nextPos[i][0];
                int nextY = curY + nextPos[i][1];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (distance[nextX][nextY] < distance[curX][curY] + 1 && distance[nextX][nextY] != 0){
                    continue;
                }

                if (map[nextX][nextY] == 1) {
                    if (!curIsBreak) {
                        distance[nextX][nextY] = distance[curX][curY] + 1;
                        q.offer(new xy(nextX, nextY, true));
                    }
                    continue;
                }
                distance[nextX][nextY] = distance[curX][curY] + 1;
                q.offer(new xy(nextX, nextY, curIsBreak));
            }
        }
        int res = -1;
        if (distance[n-1][m-1] !=0){
            res = distance[n-1][m-1];
        }
        System.out.printf("%d",res);
    }
}


class xy {
    private int x;
    private int y;
    private boolean isBreak;

    public xy(int x, int y, boolean isBreak) {
        this.x = x;
        this.y = y;
        this.isBreak = isBreak;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isBreak() {
        return isBreak;
    }
}