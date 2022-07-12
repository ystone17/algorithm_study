import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, h;
    static int[][] heights;
    static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        prefixSum = new int[2][h + 1];

        heights = new int[2][n / 2];
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            heights[i % 2][i / 2] = height;
            prefixSum[i % 2][height]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = prefixSum[i].length - 2; j > 0; j--) {
                prefixSum[i][j] += prefixSum[i][j + 1];
            }
        }

        List<Cnt> cntArr = new ArrayList<>();

        for (int i = 1; i <= h; i++) {
            int cnt = prefixSum[0][i] + prefixSum[1][h + 1 - i];
            cntArr.add(new Cnt(i, cnt));
        }

        Collections.sort(cntArr);

        int brokenMin = cntArr.get(0).cnt;
        int brokenCnt = 0;
        for (Cnt c : cntArr) {
            if (c.cnt > brokenMin) break;
            brokenCnt++;
        }

        System.out.printf("%d %d", brokenMin, brokenCnt);
    }

    static class Cnt implements Comparable<Cnt> {
        int height;
        int cnt;

        public Cnt(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Cnt o) {
            return Integer.compare(cnt, o.cnt);
        }
    }
}
