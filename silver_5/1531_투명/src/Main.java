import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, res;
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    map[y][x]++;
                }
            }
        }

        for (int y = 1; y <= 100; y++) {
            for (int x = 1; x <= 100; x++) {
                if (map[y][x] > m) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
