import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            var s1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            var s2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (s1.y > s2.q
                    || s1.q < s2.y
                    || s1.x > s2.p
                    || s1.p < s2.x) {
                System.out.println("d");
                continue;
            }

            if (s1.p == s2.x && s1.q == s2.y
                    || s1.x == s2.p && s1.y == s2.q
                    || s1.p == s2.x && s1.y == s2.q
                    || s1.x == s2.p && s1.q == s2.y) {
                System.out.println("c");
                continue;
            }

            if (s1.p == s2.x || s1.x == s2.p || s1.q == s2.y || s1.y == s2.q) {
                System.out.println("b");
                continue;
            }

            System.out.println("a");
        }
    }

    static class Square {
        int x;
        int y;
        int p;
        int q;

        public Square(int x, int y, int p, int q) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.q = q;
        }
    }
}
