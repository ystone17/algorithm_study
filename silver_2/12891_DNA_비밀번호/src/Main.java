import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int s, p, A, C, G, T, count;
    static char[] seq;
    static int[][] partSums;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        seq = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        partSums = new int[4][s + 1];

        for (int i = 0; i < seq.length; i++) {
            partSums[0][i + 1] = partSums[0][i] + (seq[i] == 'A' ? 1 : 0);
            partSums[1][i + 1] = partSums[1][i] + (seq[i] == 'C' ? 1 : 0);
            partSums[2][i + 1] = partSums[2][i] + (seq[i] == 'G' ? 1 : 0);
            partSums[3][i + 1] = partSums[3][i] + (seq[i] == 'T' ? 1 : 0);
        }

        for (int i = 0; i <= s - p; i++) {
            if (A > partSums[0][i + p] - partSums[0][i]) {
                continue;
            }

            if (C > partSums[1][i + p] - partSums[1][i]) {
                continue;
            }

            if (G > partSums[2][i + p] - partSums[2][i]) {
                continue;
            }

            if (T > partSums[3][i + p] - partSums[3][i]) {
                continue;
            }

            count++;
        }

        System.out.println(count);
    }
}
