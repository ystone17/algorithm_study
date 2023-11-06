import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, s;
    static List<Paint> paints = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Paint paint = new Paint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            paints.add(paint);
        }

        Collections.sort(paints);

        dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = getDp(i);
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }

        System.out.println(res);
    }

    static int getDp(int k) {
        if(dp[k] != 0) {
            return dp[k];
        }

        int max = 0;
        int kHeight = paints.get(k).height;
        for (int i = k + 1; i < n; i++) {
            if (paints.get(i).height - kHeight < s) {
                continue;
            }

            max = Math.max(max, getDp(i));
        }

        return dp[k] = max + paints.get(k).price;
    }

    static class Paint implements Comparable<Paint> {
        int height;
        int price;

        public Paint(int height, int price) {
            this.height = height;
            this.price = price;
        }

        @Override
        public int compareTo(Paint o) {
            return Integer.compare(height, o.height);
        }
    }
}
