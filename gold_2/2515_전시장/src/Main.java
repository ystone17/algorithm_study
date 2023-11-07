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
    static int[] dp, last;

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

        paints.add(0, new Paint(0, 0));

        dp = new int[n + 1];
        last = new int[n + 1];

        for (int i = 1; i < paints.size(); i++) {
            for (int j = last[i - 1]; j < i; j++) {
                if (paints.get(i).height - paints.get(j).height >= s) {
                    last[i] = j;
                    continue;
                }
                break;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[last[i]] + paints.get(i).price);
        }

        System.out.println(dp[n]);
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
