import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Pos a, b, c, d;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        b = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        c = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        d = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int first = ccw(a, b, c) * ccw(a, b, d);
        int second = ccw(c, d, a) * ccw(c, d, b);

        if (first == 0 && second == 0) {
            if (c.x <= b.x && a.x <= d.x && c.y <= b.y && a.y <= d.y || c.x <= b.x && a.x <= c.x && c.y <= b.y && a.y <= c.y) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        if (first == 0) {
            if (a.x <= c.x && c.x <= b.x && a.y <= c.y && c.y <= b.y || a.x <= d.x && d.x <= b.x && a.y <= d.y && d.y <= b.y) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        if (second == 0) {
            if (c.x <= a.x && a.x <= d.x && c.y <= a.y && a.y <= d.y || c.x <= b.x && b.x <= d.x && c.y <= b.y && b.y <= d.y) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        System.out.println(first * second > 0 ? 1 : 0);
    }

    private static int ccw(Pos a, Pos b, Pos c) {
        Pos ab = new Pos(b.x - a.x, b.y - a.y);
        Pos ac = new Pos(c.x - a.x, c.y - a.y);

        long res = ab.x * ac.y - ac.x * ab.y;

        if (res == 0) return 0;
        return res > 0 ? 1 : -1;
    }

    private static class Pos {
        long x;
        long y;

        public Pos(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
