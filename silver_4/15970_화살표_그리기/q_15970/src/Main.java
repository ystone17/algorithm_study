import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, res;
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int pos = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            points.add(new Point(pos, color));
        }

        Collections.sort(points);

        for (int pPos = 0; pPos < n; pPos++) {
            int dist = Integer.MAX_VALUE;
            Point p = points.get(pPos);
            for (int qPos = 0; qPos < n; qPos++) {
                if(pPos == qPos) continue;
                if(p.color != points.get(qPos).color) continue;
                dist = Math.min(dist, Math.abs(p.pos - points.get(qPos).pos));
            }
            res += dist;
        }

        System.out.println(res);
    }

    private static class Point implements Comparable<Point> {
        int pos;
        int color;

        public Point(int pos, int color) {
            this.pos = pos;
            this.color = color;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(pos, o.pos);
        }
    }
}
