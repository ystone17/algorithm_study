import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, res;
    static int[][] map;
    static int[] dy = {1, 1, 0};
    static int[] dx = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new Pipe(0, 0, 0, 1, 2));

        System.out.println(res);
    }

    static void dfs(Pipe cur){
        if(cur.y2 == n-1 && cur.x2  == n-1) {
            res++;
            return;
        }

        switch (cur.dir){
            case 0:
                for (int i = 0; i < 2; i++) {
                    doIt(cur, i);

                }
                break;
            case 1:
                for (int i = 0; i < 3; i++) {
                    doIt(cur, i);
                }
                break;
            case 2:
                for (int i = 1; i < 3; i++) {
                    doIt(cur, i);
                }
                break;
        }
    }

    private static void doIt(Main.Pipe cur, int i) {
        int ny1 = cur.y2;
        int nx1 = cur.x2;
        int ny2 = cur.y2 + dy[i];
        int nx2 = cur.x2 + dx[i];

        if (ny2 < 0 || ny2 >= n || nx2 < 0 || nx2 >= n) return;

        if(possible(ny1, nx1, ny2, nx2)){
            dfs(new Pipe(ny1, nx1, ny2, nx2, i));
        }
    }

    private static boolean possible(int ny1, int nx1, int ny2, int nx2) {
        for (int j = ny1; j <= ny2; j++) {
            for (int k = nx1; k <= nx2; k++) {
                if(map[j][k] == 1) return false;
            }
        }

        return true;
    }

    static class Pipe {
        int y1;
        int x1;
        int y2;
        int x2;
        int dir;

        public Pipe(int y1, int x1, int y2, int x2, int dir) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
            this.dir = dir;
        }
    }
}
