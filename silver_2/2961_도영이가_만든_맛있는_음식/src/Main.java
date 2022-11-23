import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res = 1_000_000_000;
    static Taste[] tastes, temp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        tastes = new Taste[n];
        temp = new Taste[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tastes[i] = new Taste(s, b);
        }

        for (int i = 1; i <= n; i++) {
            req(0, 0, i);
        }
        System.out.println(res);
    }

    static void req(int idx, int start, int size) {
        if (idx == size) {
            int s = 1;
            int b = 0;
            for (int i = 0; i < size; i++) {
                s *= temp[i].s;
                b += temp[i].b;
            }

            res = Math.min(res, Math.abs(s - b));
            return;
        }

        for (int i = start; i < n; i++) {
            temp[idx] = tastes[i];
            req(idx + 1, i + 1, size);
        }
    }


    static class Taste {
        int s;
        int b;

        public Taste(int s, int b) {
            this.s = s;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Taste{" +
                    "s=" + s +
                    ", b=" + b +
                    '}';
        }
    }
}
