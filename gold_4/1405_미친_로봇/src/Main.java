import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int E = 0, W = 1, S = 2, N = 3;

    static int n;
    static int[] percents = new int[4];
    static int[] seq;
    static int[][] map;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean isSimple;
    static Fraction fraction = new Fraction();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        percents[E] = Integer.parseInt(st.nextToken());
        percents[W] = Integer.parseInt(st.nextToken());
        percents[S] = Integer.parseInt(st.nextToken());
        percents[N] = Integer.parseInt(st.nextToken());

        seq = new int[n];
        req(0);

        System.out.printf("%.9f", (double) fraction.child / fraction.parent);
    }

    private static void req(int idx) {
        if (idx >= n) {

            map = new int[30][30];

            int y = 15;
            int x = 15;
            map[15][15] = 1;

            Fraction f = new Fraction();
            isSimple = true;

            for (int i : seq) {
                y += dy[i];
                x += dx[i];

                if (map[y][x] == 1) {
                    isSimple = false;
                }
                map[y][x]++;
                f.mul(percents[i], 100);
            }

            if (isSimple) {
                fraction.add(f.child, f.parent);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (percents[i] == 0) {
                continue;
            }

            seq[idx] = i;
            req(idx + 1);
        }
    }

    private static class Fraction {
        int child;
        int parent;

        private void add(int child, int parent) {
            if (this.parent == 0) {
                this.child = child;
                this.parent = parent;
                return;
            }
            this.child = this.child * parent + child * this.parent;
            this.parent *= parent;

            simplify();
        }

        private void mul(int child, int parent) {
            if (this.parent == 0) {
                this.child = child;
                this.parent = parent;
                return;
            }

            this.child *= child;
            this.parent *= parent;

            simplify();
        }

        private void simplify() {
            int gcd = gcd();

            this.child /= gcd;
            this.parent /= gcd;
        }

        private int gcd() {
            int a = this.parent;
            int b = this.child;

            while (b != 0) {
                int temp = a;
                a = b;
                b = temp % b;
            }

            return a;
        }
    }
}
