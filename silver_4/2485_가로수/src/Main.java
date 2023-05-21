import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, seqMin = Integer.MAX_VALUE, answer = Integer.MAX_VALUE;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(seq);


        for (int i = 1; i < seq.length; i++) {
            seqMin = Math.min(seqMin, seq[i] - seq[i - 1]);
        }

        for (int i = 1; i <= seqMin; i++) {
            answer = Math.min(answer, getTreeCnt(i));
        }

        System.out.println(answer);

    }

    static int getTreeCnt(int k) {
        int total = 0;
        for (int i = 1; i < seq.length; i++) {
            int dist = seq[i] - seq[i - 1];
            if (dist % k != 0) {
                return Integer.MAX_VALUE;
            }

            total += dist / k - 1;
        }

        return total;
    }
}
