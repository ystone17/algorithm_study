import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        int[][] maze = new int[x][y];
        int[][] dist = new int[x][y];
        int[][] fire = new int[x][y];

        Queue<Pair> Q = new LinkedList<>();
        Pair jihun = null;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < x; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < y; j++) {
                if (line[j] == '#') {
                    maze[i][j] = 0;
                } else if (line[j] == '.') {
                    maze[i][j] = 1;
                } else if (line[j] == 'J') {
                    maze[i][j] = 1;
                    dist[i][j] = 1;
                    jihun = new Pair(i, j);
                } else if (line[j] == 'F') {
                    maze[i][j] = 1;
                    fire[i][j] = 1;
                    Q.offer(new Pair(i, j));
                }
            }
        }



        while (!Q.isEmpty()) {
            Pair cur = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    continue;
                }

                if (fire[nx][ny] >= 1 || maze[nx][ny] == 0) {
                    continue;
                }

                fire[nx][ny] = fire[cur.getX()][cur.getY()] + 1;
                Q.offer(new Pair(nx, ny));
            }
        }

        Q.offer(jihun);
        while (!Q.isEmpty()) {
            Pair cur = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    continue;
                }

                if (dist[nx][ny] >= 1 || maze[nx][ny] == 0) {
                    continue;
                }

                if (fire[nx][ny] > 0 && dist[cur.getX()][cur.getY()] + 1 >= fire[nx][ny]) {
                    continue;
                }

                dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;
                Q.offer(new Pair(nx, ny));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (maze[i][j] == 1 && (i == 0 || i == x - 1 || j == 0 || j == y - 1)){
                    if(min > dist[i][j] && dist[i][j] != 0){
                        min = dist[i][j];
                    }
                }
            }
        }




        if (min == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        } else{
            System.out.printf("%d",min);
        }

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