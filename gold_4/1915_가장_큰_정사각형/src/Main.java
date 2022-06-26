import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
//        prefixSum();
        dp();
    }

    static int[][] prefixSum;


    static void prefixSum() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        prefixSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + map[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) continue;

                int idx = 1;
                int res = 1;
                while (i + idx <= n && j + idx <= m) {
                    int size = prefixSum[i + idx][j + idx] - prefixSum[i - 1][j + idx] - prefixSum[i + idx][j - 1] + prefixSum[i - 1][j - 1];

                    idx++;
                    if (size != idx * idx) break;
                    res = idx * idx;
                }

                answer = Math.max(answer, res);
            }
        }

        System.out.println(answer);
    }

    static int[][] dp;

    static void dp() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                int temp = Integer.parseInt(split[j - 1]);

                if (i == 1 && j == 1) {
                    dp[i][j] = temp;
                    answer = temp;
                } else {
                    if (temp == 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        answer = Math.max(answer, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(answer * answer);
    }

}
