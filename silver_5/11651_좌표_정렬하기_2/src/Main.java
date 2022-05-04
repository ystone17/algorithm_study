import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        Pos[] seq = new Pos[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            seq[i] = new Pos(y, x);
        }

        Arrays.sort(seq);

        for (Pos pos : seq) {
            System.out.println(pos);
        }


    }

    static class Pos implements Comparable<Pos> {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Pos o) {
            if (y != o.y) {
                return Integer.compare(y, o.y);
            } else {
                return Integer.compare(x, o.x);
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
