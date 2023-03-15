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

        if (first * second == 1) {
            if (first == 1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            return;
        }

        if (first * second == -1) {
            System.out.println(0);
            return;
        }

        if (first == 0 && second == 0) {
            if (onLine(a, b, c) || onLine(a, b, d) || onLine(c, d, a) || onLine(c, d, b)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        if (first == 0) {
            if (abc == 0) {
                // ab 직선 위에 c가 있어야 함
                if (onLine(a, b, c)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                // ab 직선 위에 d가 있어야 함
                if (onLine(a, b, d)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            return;
        }

        if (second == 0) {
            if (cda == 0) {
                // cd 직선 위에 a가 있어야 함
                if (onLine(c, d, a)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                // cd 직선 위에 b가 있어야 함
                if (onLine(c, d, b)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            return;
        }


        System.out.println(0);
    }

    private static boolean onLine(Pos a, Pos b, Pos c) {
        long dy = b.y - a.y;
        long dx = b.x - a.x;
        long dyy = b.y - c.y;
        long dxx = b.x - c.x;

        if (dy * dxx != dx * dyy) {
            return false;
        }

        return Math.min(a.y, b.y) <= c.y && c.y <= Math.max(a.y, b.y) && Math.min(a.x, b.x) <= c.x && c.x <= Math.max(a.x, b.x);
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
