import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        int[][] board = new int[x][y];
        int[][] visited = new int[x][y];
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> startQ = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < x; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 1){
                    startQ.offer(new Pair(i, j));
                }
            }
        }
        int num = 0;
        int maxSize = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 0 || visited[i][j] == 1) {
                    continue;
                }
                num++;
                int size = 1;
                visited[i][j] = 1;
                queue.offer(new Pair(i, j));

                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nextX = cur.getX() + dx[k];
                        int nextY = cur.getY() + dy[k];

                        if (nextX < 0 || nextX >= x || nextY < 0 || nextY >= y){
                            continue;
                        }
                        if (visited[nextX][nextY] ==1 || board[nextX][nextY] != 1){
                            continue;
                        }
                        visited[nextX][nextY] = 1;
                        queue.offer(new Pair(nextX, nextY));
                        size++;
                    }

                }
                if (maxSize < size){
                    maxSize = size;
                }
            }
        }
        System.out.printf("%d\n%d",num, maxSize);

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
