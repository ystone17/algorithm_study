import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[] fuels, dist;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        fuels = new long[n];
        dist = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            dist[i] = dist[i - 1] + Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fuels[i] = Integer.parseInt(st.nextToken());
        }

        long sum = dist[n - 1] * fuels[0];
        int station = 0;
        for (int i = 1; i < n - 1; i++) {
            long total = (dist[n - 1] - dist[station]) * fuels[station];
            long temp = (dist[i] - dist[station]) * fuels[station] + (dist[n - 1] - dist[i]) * fuels[i];
            if (total > temp) {
                sum = sum - total + temp;
                station = i;
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
