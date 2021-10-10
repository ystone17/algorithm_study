import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcNum = Integer.parseInt(br.readLine());
        int[][] next = {
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < tcNum; i++) {
            int size = Integer.parseInt(br.readLine());
            String[] now = br.readLine().split(" ");
            String[] hope = br.readLine().split(" ");
            int x = Integer.parseInt(now[0]);
            int y = Integer.parseInt(now[1]);
            Pair N = new Pair(x,y);
            Pair goal = new Pair(Integer.parseInt(hope[0]),Integer.parseInt(hope[1]));
            if (N.equals(goal)){
                System.out.println(0);
                continue;
            }
//            int[][] board = new int[size][size];
            int[][] visited = new int[size][size];


            visited[x][y] = 1;
            q.offer(N);
            while (!q.isEmpty()){
                Pair curr = q.poll();
                int cx = curr.getX();
                int cy = curr.getY();

                for (int j = 0; j < 8; j++) {
                    int nx = cx + next[j][0];
                    int ny = cy + next[j][1];
                    if (nx < 0 || nx >= size || ny < 0 || ny >= size || visited[nx][ny] >= 1){
                        continue;
                    }

                    Pair Next = new Pair(nx,ny);
                    if (Next.equals(goal)){
                        System.out.println(visited[cx][cy]);
                        q.clear();
                        break;
                    }

                    visited[nx][ny] = visited[cx][cy] + 1;
                    q.offer(new Pair(nx,ny));
                }
            }

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

    public boolean equals(Pair p) {
        return this.x == p.x && this.y == p.y;
    }
}