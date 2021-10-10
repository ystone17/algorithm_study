import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineNum = Integer.parseInt(br.readLine());
        String[][] art = new String[lineNum][lineNum];
        int[][] rgbVisited = new int[lineNum][lineNum];
        int[][] bVisited = new int[lineNum][lineNum];
        Queue<Pair> q = new LinkedList<>();
        int[][] move = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        for (int i = 0; i < lineNum; i++) {
            art[i] = br.readLine().split("");
        }

        // 정상
        int res1 = 0;
        for (int x = 0; x < lineNum; x++) {
            for (int y = 0; y < lineNum; y++) {
                if (rgbVisited[x][y] == 1) {
                    continue;
                }

                rgbVisited[x][y] = 1;
                q.offer(new Pair(x, y));
                res1++;

                while (!q.isEmpty()) {
                    Pair curr = q.poll();
                    int cx = curr.getX();
                    int cy = curr.getY();

                    for (int i = 0; i < 4; i++) {
                        int nx = cx + move[i][0];
                        int ny = cy + move[i][1];

                        if (nx < 0 || nx >= lineNum || ny < 0 || ny >= lineNum) {
                            continue;
                        }

                        if (rgbVisited[nx][ny] == 1 || !art[cx][cy].equals(art[nx][ny])) {
                            continue;
                        }

                        rgbVisited[nx][ny] = 1;
                        q.offer(new Pair(nx, ny));

                    }

                }

            }
        }
        System.out.printf("%d ",res1);

        // 색약
        int res2 = 0;
        for (int x = 0; x < lineNum; x++) {
            for (int y = 0; y < lineNum; y++) {
                if (bVisited[x][y] == 1) {
                    continue;
                }

                bVisited[x][y] = 1;
                q.offer(new Pair(x, y));
                res2++;


                while (!q.isEmpty()) {
                    Pair curr = q.poll();
                    int cx = curr.getX();
                    int cy = curr.getY();

                    for (int i = 0; i < 4; i++) {
                        int nx = cx + move[i][0];
                        int ny = cy + move[i][1];

                        if (nx < 0 || nx >= lineNum || ny < 0 || ny >= lineNum) {
                            continue;
                        }

                        if (bVisited[nx][ny] == 1) {
                            continue;
                        }

                        if (art[cx][cy].equals("B")) {
                            if (!art[nx][ny].equals("B"))
                                continue;
                        } else if (art[nx][ny].equals("B")) {
                            continue;
                        }

                        bVisited[nx][ny] = 1;
                        q.offer(new Pair(nx, ny));

                    }

                }
            }
        }
        System.out.println(res2);
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