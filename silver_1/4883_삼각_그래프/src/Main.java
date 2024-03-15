import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, count = 1;
    static int[][] dist, result;

    public static void main(String[] args) throws IOException {


        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }
            dist = new int[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    dist[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = new int[n][3];
            for (int i = 0; i < n; i++) {
                Arrays.fill(result[i], 1_000_000_000);
            }
            result[0][1] = dist[0][1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        result[i][j + 1] = Math.min(result[i][j + 1], result[i][j] + dist[i][j + 1]);
                        if (i != n - 1) {
                            result[i + 1][j] = Math.min(result[i + 1][j], result[i][j] + dist[i + 1][j]);
                            result[i + 1][j + 1] = Math.min(result[i + 1][j + 1], result[i][j] + dist[i + 1][j + 1]);
                        }
                    }

                    if (j == 1) {
                        result[i][j + 1] = Math.min(result[i][j + 1], result[i][j] + dist[i][j + 1]);
                        if (i != n - 1) {
                            result[i + 1][j - 1] = Math.min(result[i + 1][j - 1], result[i][j] + dist[i + 1][j - 1]);
                            result[i + 1][j] = Math.min(result[i + 1][j], result[i][j] + dist[i + 1][j]);
                            result[i + 1][j + 1] = Math.min(result[i + 1][j + 1], result[i][j] + dist[i + 1][j + 1]);
                        }
                    }

                    if (j == 2) {
                        if (i != n - 1) {
                            result[i + 1][j - 1] = Math.min(result[i + 1][j - 1], result[i][j] + dist[i + 1][j - 1]);
                            result[i + 1][j] = Math.min(result[i + 1][j], result[i][j] + dist[i + 1][j]);
                        }
                    }
                }
            }

            sb.append(String.format("%d. %d\n", count++, result[n - 1][1]));
        }

        System.out.println(sb);

    }
}
