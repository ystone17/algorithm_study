import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int vNum, answer;
    static int[][] minDist, edges;

    public static void main(String[] args) throws IOException {
        vNum = Integer.parseInt(br.readLine());

        minDist = new int[vNum][vNum];
        edges = new int[vNum][vNum];

        for (int i = 0; i < vNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < vNum; j++) {
                minDist[i][j] = Integer.parseInt(st.nextToken());
                edges[i][j] = minDist[i][j];
            }
        }

        for (int k = 0; k < vNum; k++) {
            for (int u = 0; u < vNum; u++) {
                for (int v = 0; v < vNum; v++) {
                    if (u == v) continue;
                    if (u == k || v == k) continue;
                    if (edges[u][v] >= edges[u][k] + edges[k][v]) {
                        edges[u][v] = 1_00_000_000;
                    }

                }
            }
        }

        for (int[] edge : edges) {
            for (int i : edge) {
                if (i == 1_00_000_000) continue;
                answer += i;
            }
        }

        for (int k = 0; k < vNum; k++) {
            for (int u = 0; u < vNum; u++) {
                for (int v = 0; v < vNum; v++) {
                    if (u == v) continue;
                    if (edges[u][v] > edges[u][k] + edges[k][v]) {
                        edges[u][v] = edges[u][k] + edges[k][v];
                    }

                }
            }
        }

        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                if (edges[i][j] != minDist[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer / 2);

    }
}
