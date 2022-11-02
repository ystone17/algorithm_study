import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 1;

        long a;
        if (k != -1) {
            a = solution(k / m + 1, k % m + 1);
            a *= solution(n - k / m, m - k % m);
        } else {
            a = solution(n, m);
        }

        System.out.println(a);
    }

    static long solution(int y, int x) {
        long[][] map = new long[y + 1][x + 1];
        map[1][1] = 1;
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (i == 1 && j == 1) continue;
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        return map[y][x];
    }


}
