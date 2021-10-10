import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcNum = Integer.parseInt(br.readLine());
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for (int i = 0; i < tcNum; i++) {
            q.clear();
            String[] xyb = br.readLine().split(" ");
            int x = Integer.parseInt(xyb[0]);
            int y = Integer.parseInt(xyb[1]);
            int b = Integer.parseInt(xyb[2]);

            int[][] ground = new int[x][y];
            int[][] visited = new int[x][y];
            for (int j = 0; j < b; j++) {
                String[] bxby = br.readLine().split(" ");
                int bx = Integer.parseInt(bxby[0]);
                int by = Integer.parseInt(bxby[1]);

                ground[bx][by] = 1;
            }

            int res = 0;
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if (ground[j][k] == 0) {
                        continue;
                    }

                    if (visited[j][k] == 1){
                        continue;
                    }
                    res++;
                    visited[j][k] = 1;
                    q.offer(new Pair(j,k));

                    while (!q.isEmpty()){
                        Pair curr = q.poll();
                        int cx = curr.getX();
                        int cy = curr.getY();
                        for (int l = 0; l < 4; l++) {
                            int nx = cx + dx[l];
                            int ny = cy + dy[l];

                            if (nx < 0 || nx >= x || ny < 0 || ny >=y){
                                continue;
                            }

                            if (ground[nx][ny] == 0 ||  visited[nx][ny] == 1){
                                continue;
                            }

                            visited[nx][ny] = 1;
                            q.offer(new Pair(nx, ny));
                        }

                    }
                }
            }

            System.out.println(res);

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