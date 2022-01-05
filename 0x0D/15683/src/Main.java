import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, min, minTemp;
    static int[][] office;
    static int[][] officeCopy;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Pair<Integer, Integer>> cctvList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office = new int[n][m];
        officeCopy = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] == 0) min++;
                else if (office[i][j] != 6) cctvList.add(new Pair<>(i, j));
            }
        }

        minTemp = min;

        for (int i = 0; i < 1 << 2 * cctvList.size(); i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    officeCopy[j][k] = office[j][k];
                }

            }

            int tmp = i;
            for (Pair<Integer, Integer> cctv : cctvList) {
                int dir = tmp % 4;
                tmp /= 4;
                switch (officeCopy[cctv.y][cctv.x]) {
                    case 1:
                        see(cctv.y, cctv.x, dir);
                        break;
                    case 2:
                        see(cctv.y, cctv.x, dir);
                        see(cctv.y, cctv.x, dir + 2);
                        break;
                    case 3:
                        see(cctv.y, cctv.x, dir);
                        see(cctv.y, cctv.x, dir + 1);
                        break;
                    case 4:
                        see(cctv.y, cctv.x, dir);
                        see(cctv.y, cctv.x, dir + 1);
                        see(cctv.y, cctv.x, dir + 2);
                        break;
                    case 5:
                        see(cctv.y, cctv.x, dir);
                        see(cctv.y, cctv.x, dir + 1);
                        see(cctv.y, cctv.x, dir + 2);
                        see(cctv.y, cctv.x, dir + 3);
                }
            }

            int val = 0;

            for (int[] row : officeCopy) {
                for (int cell : row) {
                    if (cell == 7) val++;
                }
            }

            min = Math.min(min, minTemp - val);
        }
        System.out.println(min);
    }

    static void see(int y, int x, int dir) {
        dir %= 4;
        while (true) {
            y += dy[dir];
            x += dx[dir];

            if (y < 0 || y >= n || x < 0 || x >= m || officeCopy[y][x] == 6) return;
            if (officeCopy[y][x] != 0) continue;

            officeCopy[y][x] = 7;
        }
    }


    static class Pair<Y, X> {
        Y y;
        X x;

        private Pair(Y y, X x) {
            this.y = y;
            this.x = x;
        }
    }
}



