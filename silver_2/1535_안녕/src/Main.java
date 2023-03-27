import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] l, j;
    static int n, res;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        l = new int[n];
        j = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            j[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        req(0, 100, 0);
        System.out.println(res);
    }

    static void req(int idx, int health, int heart) {
        if (idx >= n) {
            res = Math.max(res, heart);
            return;
        }

        if (health - j[idx] > 0) req(idx + 1, health - j[idx], heart + l[idx]);
        req(idx + 1, health, heart);
    }
}
