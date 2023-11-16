import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int[] kits, used;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kits = new int[n];
        used = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(bruteForce(0, 500));
    }

    static int bruteForce(int idx, int total) {
        if (idx >= n) {
            return 1;
        }

        int res = 0;
        total -= k;

        for (int i = 0; i < kits.length; i++) {
            if (used[i] == 1 || total + kits[i] < 500) {
                continue;
            }

            used[i] = 1;
            res += bruteForce(idx + 1, total + kits[i]);
            used[i] = 0;
        }

        return res;
    }
}
