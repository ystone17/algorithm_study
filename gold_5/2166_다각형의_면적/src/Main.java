import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[][] points;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        points = new long[n + 1][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        points[n][0] = points[0][0];
        points[n][1] = points[0][1];

        long a = 0;
        for (int i = 0; i < n; i++) {
            a += points[i][0] * points[i + 1][1];
        }

        long b = 0;
        for (int i = 0; i < n; i++) {
            b += points[i][1] * points[i + 1][0];
        }

        double res = Math.abs((double) (a - b) / 2);
        res = (double) Math.round(res * 10) / 10;

        System.out.printf("%.1f",res);
    }
}
