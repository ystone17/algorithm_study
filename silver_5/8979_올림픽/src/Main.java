import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static Nation[] nations;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nations = new Nation[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nations[i] = new Nation(number, g, s, b);
        }

        Arrays.sort(nations);

        for (int i = 0; i < nations.length; i++) {
            if (nations[i].number == k) {
                System.out.println(i + 1);
                return;
            }
        }

    }

    static class Nation implements Comparable<Nation> {
        int number;
        int g;
        int s;
        int b;

        public Nation(int number, int g, int s, int b) {
            this.number = number;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public int compareTo(Nation o) {
            if (g != o.g) {
                return Integer.compare(o.g, g);
            } else if (s != o.s) {
                return Integer.compare(o.s, s);
            } else if (b != o.b) {
                return Integer.compare(o.b, b);
            } else if (number == k) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
