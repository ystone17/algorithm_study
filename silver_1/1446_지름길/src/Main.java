import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, d;
    static List<ShortCut> shortCuts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            shortCuts.add(new ShortCut(u, v, dist));
        }

        Collections.sort(shortCuts);

        System.out.println(minDist(0, 0));
    }

    private static int minDist(int cur, int dist) {
        if (cur == d) {
            return dist;
        }

        if (cur > d) {
            return Integer.MAX_VALUE;
        }

        int minDist = dist + (d - cur);

        for (ShortCut shortCut : shortCuts) {
            if (shortCut.start < cur) {
                continue;
            }

            minDist = Math.min(minDist, minDist(shortCut.end, dist + (shortCut.start - cur) + shortCut.dist));
        }

        return minDist;
    }

    private static class ShortCut implements Comparable<ShortCut> {
        int start;
        int end;
        int dist;

        public ShortCut(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(ShortCut o) {
            if (start != o.start) {
                return Integer.compare(start, o.start);
            }

            if (end != o.end) {
                return Integer.compare(end, o.end);
            }

            return Integer.compare(dist, o.dist);
        }
    }
}
