import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int v, e, tc;
    static int[][] events;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        events = new int[v + 1][v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            events[u][v] = -1;
            events[v][u] = 1;
        }

        floyd();

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(events[u][v]).append("\n");
        }

        System.out.println(sb);

    }

    static void floyd() {
        for (int m = 1; m < v + 1; m++) {
            for (int u = 1; u < v + 1; u++) {
                for (int cv = 1; cv < v + 1; cv++) {
                    if (u == cv) continue;
                    if (events[u][m] == 1 && events[m][cv] == 1) events[u][cv] = 1;
                    else if (events[u][m] == -1 && events[m][cv] == -1) events[u][cv] = -1;
                }
            }
        }
    }
}
