import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, y, k;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0,};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        visited = new int[x + 1][y + 1];

        k = Integer.parseInt(br.readLine());

        if (k > x * y) {
            System.out.println(0);
            return;
        }

        int dir = 0;
        int cy = 1, cx = 1;
        visited[cx][cy] = 1;
        for (int i = 1; i < k; i++) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx > x || nx <= 0 || ny > y || ny <= 0 || visited[nx][ny] == 1) {
                dir = (dir + 1) % 4;
                nx = cx + dx[dir];
                ny = cy + dy[dir];
            }

            visited[nx][ny] = 1;
            cx = nx;
            cy = ny;
        }

        System.out.printf("%d %d", cx, cy);

    }
}
