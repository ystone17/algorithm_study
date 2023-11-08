import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res;
    static int[][] weight;
    static int[] dist, select;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        weight = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            int w = Integer.parseInt(br.readLine());
            weight[i][n] = w;
            weight[n][i] = w;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dist = new int[n + 1];
        select = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            dist[i] = weight[0][i];
        }
        select[0] = 1;

        for (int i = 0; i < n; i++) {
            int minDist = Integer.MAX_VALUE;
            int nextSelect =  -1;
            for (int v = 0; v <= n; v++) {
                if(select[v] == 0 && dist[v] < minDist) {
                    minDist = dist[v];
                    nextSelect = v;
                }
            }

            select[nextSelect] = 1;
            res += minDist;
            for (int j = 0; j < weight[nextSelect].length; j++) {
                if(j == nextSelect) {
                    continue;
                }

                if(weight[nextSelect][j] < dist[j]) {
                    dist[j] = weight[nextSelect][j];
                }
            }
        }

        System.out.println(res);
    }
}
