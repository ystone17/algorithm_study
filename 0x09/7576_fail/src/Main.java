import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 모든 시작점에서 bfs 따로 발생하는 함수
    // 각 bfs가 끝까지 도달한 후 덮어쓰는 형식으로 bfs 진행
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[1]);
        int y = Integer.parseInt(xy[0]);
        int[][] board = new int[x][y];
        int[][] day = new int[x][y];
        Queue<Pair> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < x; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        Pair cur = null;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] != 1) {
                    continue;
                }

                day[i][j] = 1;
                queue.offer(new Pair(i, j));

                while (!queue.isEmpty()) {
                    cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nextX = cur.getX() + dx[k];
                        int nextY = cur.getY() + dy[k];

                        if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) {
                            continue;
                        }
                        if (board[nextX][nextY] != 0){
                            continue;
                        }
                        if (day[nextX][nextY] >= 1 && day[nextX][nextY] <= day[cur.getX()][cur.getY()] + 1) {
                            continue;
                        }
                        day[nextX][nextY] = day[cur.getX()][cur.getY()] + 1;


//                        System.out.printf("[%d %d]\n",cur.getX(), cur.getY());
//                        for (int l = 0; l < x; l++) {
//                            for (int m = 0; m < y; m++) {
//                                System.out.printf("%d ",day[l][m]);
//                            }
//                            System.out.println();
//                        }

                        queue.offer(new Pair(nextX, nextY));
//                        System.out.print("[ ");
//                        for (Pair pair : queue) {
//                            System.out.printf("{ %d , %d } ", pair.getX(), pair.getY());
//                        }
//                        System.out.println("]");
//
//                        br.readLine();
                    }
                }
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
        System.out.printf("%d", maxDay-1);
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
