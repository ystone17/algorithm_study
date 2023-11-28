import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max = -1, maxIdx, gcd;
    static int[] seq, partGcdLtoR, partGcdRtoL;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        partGcdLtoR = new int[n];
        partGcdRtoL = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        partGcdLtoR[0] = seq[0];
        for (int i = 1; i < seq.length; i++) {
            partGcdLtoR[i] = gcd(partGcdLtoR[i - 1], seq[i]);
        }

        partGcdRtoL[n - 1] = seq[n - 1];
        for (int i = seq.length - 2; i >= 0; i--) {
            partGcdRtoL[i] = gcd(partGcdRtoL[i + 1], seq[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            gcd = gcd(partGcdLtoR[i - 1], partGcdRtoL[i + 1]);
            if (seq[i] % gcd == 0) {
                continue;
            }

            if (max < gcd(partGcdLtoR[i - 1], partGcdRtoL[i + 1])) {
                max = gcd;
                maxIdx = i;
            }
        }

        if (max < partGcdLtoR[n - 2] && seq[n - 1] % partGcdLtoR[n - 2] != 0) {
            max = partGcdLtoR[n - 2];
            maxIdx = n - 1;
        }

        if (max < partGcdRtoL[1] && seq[0] % partGcdRtoL[1] != 0) {
            max = partGcdRtoL[1];
            maxIdx = 0;
        }

        if (max == -1) {
            System.out.print(-1);
        } else {
            System.out.printf("%d %d", max, seq[maxIdx]);
        }

    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
