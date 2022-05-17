import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int maxV, maxE;
    static int[][] adjust;

    public static void main(String[] args) throws IOException {
        maxV = Integer.parseInt(br.readLine());
        maxE = Integer.parseInt(br.readLine());
        adjust = new int[maxV + 1][maxV + 1];

        for (int i = 0; i < maxE; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjust[u][v] = 1;
        }

        for (int k = 1; k < maxV + 1; k++) {
            for (int i = 1; i < maxV + 1; i++) {
                for (int j = 1; j < maxV + 1; j++) {
                    if (i == j) continue;
                    if (adjust[i][k] == 1 && adjust[k][j] == 1) adjust[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < maxV + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < maxV + 1; j++) {
                if (i == j) continue;
                if (adjust[i][j] == 0 && adjust[j][i] == 0) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
