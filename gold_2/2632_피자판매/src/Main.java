import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int aSize, bSize;
    static int[] aSeq, bSeq;
    static int[] aCountSort = new int[1_000_001], bCountSort = new int[1_000_001];
    static long res;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        aSize = Integer.parseInt(st.nextToken());
        bSize = Integer.parseInt(st.nextToken());

        aSeq = new int[aSize];
        bSeq = new int[bSize];

        for (int i = 0; i < aSize; i++) {
            aSeq[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < bSize; i++) {
            bSeq[i] = Integer.parseInt(br.readLine());
        }

        int total;
        for (int startIdx = 0; startIdx < aSize; startIdx++) {
            total = 0;

            for (int i = 0; i < aSize - 1; i++) {
                total += aSeq[(startIdx + i) % aSize];
                if (total > n) {
                    break;
                }
                aCountSort[total]++;
            }
        }
        total = 0;
        for (int i : aSeq) {
            total += i;
        }
        if (total <= n) {
            aCountSort[total]++;
        }

        for (int startIdx = 0; startIdx < bSize; startIdx++) {
            total = 0;

            for (int i = 0; i < bSize - 1; i++) {
                total += bSeq[(startIdx + i) % bSize];
                if (total > n) {
                    break;
                }
                bCountSort[total]++;
            }
        }
        total = 0;
        for (int i : bSeq) {
            total += i;
        }
        if (total <= n) {
            bCountSort[total]++;
        }

        aCountSort[0] = bCountSort[0] = 1;
        for (int i = 0; i <= 1_000_000 && i <= n; i++) {
            res += (long) aCountSort[i] * bCountSort[n - i];
        }

        System.out.println(res);
    }
}
