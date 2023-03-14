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

        int abc = ccw(a, b, c);
        int abd = ccw(a, b, d);
        int first = abc * abd;

        int cda = ccw(c, d, a);
        int cdb = ccw(c, d, b);
        int second = cda * cdb;

        if (first == 0 && second == 0) {
            long ax = a.x;
            long bx = b.x;
            if (ax > bx) {
                long temp = ax;
                ax = bx;
                bx = temp;
            }
            long cx = c.x;
            long dx = d.x;

            long ay = a.y;
            long by = b.y;
            if (ay > by) {
                long temp = ay;
                ay = by;
                by = temp;
            }
            long cy = c.y;
            long dy = d.y;

            if (ax <= cx && cx <= bx && ay <= cy && cy <= by || ax <= dx && dx <= bx && ay <= dy && dy <= by) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        if (first == 0) {
            long ax = a.x;
            long bx = b.x;
            if (ax > bx) {
                long temp = ax;
                ax = bx;
                bx = temp;
            }
            long cx = c.x;
            long dx = d.x;

            long ay = a.y;
            long by = b.y;
            if (ay > by) {
                long temp = ay;
                ay = by;
                by = temp;
            }
            long cy = c.y;
            long dy = d.y;

            if (abc == 0) {
                if (ax <= cx && cx <= bx && ay <= cy && cy <= by) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                return;
            }

            if (abd == 0) {
                if (ax <= dx && dx <= bx && ay <= dy && dy <= by) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                return;
            }

            return;
        }

        if (second == 0) {
            long cx = c.x;
            long dx = d.x;
            if (cx > dx) {
                long temp = cx;
                cx = dx;
                dx = temp;
            }
            long ax = a.x;
            long bx = b.x;

            long cy = c.y;
            long dy = d.y;
            if (cy > dy) {
                long temp = cy;
                cy = dy;
                dy = temp;
            }
            long ay = a.y;
            long by = b.y;

            if (cda == 0) {
                if (cx <= ax && ax <= dx && cy <= ay && ay <= dy) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                return;
            }

            if (cdb == 0) {
                if (cx <= bx && bx <= dx && cy <= by && by <= dy) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                return;
            }

            return;
        }

        System.out.println(first < 0 && second < 0 ? 1 : 0);
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
