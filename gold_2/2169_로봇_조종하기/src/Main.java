import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[][] mars;
    static int[][] dist;
    static int[][] temp;

    static int[] dy = {0, 1, 0};
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mars = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist = new int[n][m];
        dist[0][0] = mars[0][0];
        for (int i = 1; i < m; i++) {
            dist[0][i] = dist[0][i - 1] + mars[0][i];
        }

        temp = new int[2][m];
        for (int y = 1; y < n; y++) {
            temp[0][0] = dist[y - 1][0] + mars[y][0];
            for (int x = 1; x < m; x++) {
                temp[0][x] = Math.max(dist[y - 1][x], temp[0][x - 1]) + mars[y][x];
            }

            temp[1][m - 1] = dist[y - 1][m - 1] + mars[y][m - 1];
            for (int x = m - 2; x >= 0; x--) {
                temp[1][x] = Math.max(dist[y - 1][x], temp[1][x + 1]) + mars[y][x];
            }

            for (int x = 0; x < m; x++) {
                dist[y][x] = Math.max(temp[0][x], temp[1][x]);
            }
        }

        System.out.println(dist[n - 1][m - 1]);
    }
}
