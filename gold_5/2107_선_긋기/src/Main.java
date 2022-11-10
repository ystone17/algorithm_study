import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Line[] lines;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        lines = new Line[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines[i] = new Line(s, e);
        }

        Arrays.sort(lines);

        int lastS = lines[0].s;
        int lastE = lines[0].e;
        int res = 0;

        for (int i = 1; i < lines.length; i++) {
            if (lastE < lines[i].s) {
                res += lastE - lastS;
                lastS = lines[i].s;
            }
            lastE = Math.max(lastE, lines[i].e);
        }

        System.out.println(res + (lastE - lastS));
    }

    static class Line implements Comparable<Line> {
        int s;
        int e;

        public Line(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Line o) {
            if (s != o.s) {
                return Integer.compare(s, o.s);
            } else {
                return Integer.compare(e, o.e);
            }
        }
    }
}
