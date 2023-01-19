import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] home = new int[200_001];
    static int homeCnt, idxBefore, resultIdx;
    static long minDist, resultMax = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            home[h]++;
            minDist += h;
        }

        for (int i = 1; i < home.length; i++) {
            if (home[i] == 0) continue;
            long dist = i - idxBefore;

            minDist = minDist - (dist * (n - homeCnt)) + (dist * homeCnt);
            homeCnt += home[i];
            idxBefore = i;

            if (resultMax > minDist) {
                resultMax = minDist;
                resultIdx = i;
            }
        }

        System.out.println(resultIdx);
    }
}
