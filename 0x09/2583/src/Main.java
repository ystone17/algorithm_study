import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mnk = br.readLine().split(" ");
        int m = Integer.parseInt(mnk[0]);
        int n = Integer.parseInt(mnk[1]);
        int k = Integer.parseInt(mnk[2]);
        int[][] board = new int[m][n];
        int[][] visited = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < k; i++) {
            String[] xyxy = br.readLine().split(" ");
            int dwx = Integer.parseInt(xyxy[0]);
            int dwy = Integer.parseInt(xyxy[1]);
            int upx = Integer.parseInt(xyxy[2]);
            int upy = Integer.parseInt(xyxy[3]);

            for (int j = dwx; j < upx; j++) {
                for (int l = dwy; l < upy; l++) {
                    board[l][j] = 1;
                }
            }
        }
        List<Integer> sizeList = new ArrayList<>();

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if(board[x][y] == 1 || visited[x][y] == 1){
                    continue;
                }

                int size = 1;
                visited[x][y] = 1;
                q.offer(new Pair(x,y));

                while (!q.isEmpty()){
                    Pair curr = q.poll();
                    int cx = curr.getX();
                    int cy = curr.getY();

                    for (int i = 0; i < 4; i++) {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n){
                            continue;
                        }
                        if(board[nx][ny] == 1 || visited[nx][ny] == 1){
                            continue;
                        }

                        size++;
                        visited[nx][ny] = 1;
                        q.offer(new Pair(nx, ny));

                    }
                }
                sizeList.add(size);
            }
        }
        Collections.sort(sizeList);
        System.out.println(sizeList.size());
        for (Integer integer : sizeList) {
            System.out.printf("%d ",integer);
        }
        System.out.println();
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
