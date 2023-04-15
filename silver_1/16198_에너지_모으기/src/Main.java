import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] seq, used;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        used = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print( req(0, 0));
    }

    static int req(int cnt, int res) {
        if (cnt >= n - 2) {
            return res;
        }

        int temp = 0;
        int left = 0;
        int right = 0;

        for (int i = 1; i < n - 1; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (used[j] == 0) {
                    left = seq[j];
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (used[j] == 0) {
                    right = seq[j];
                    break;
                }
            }

            temp = Math.max(temp, req(cnt + 1, res + left * right));
            used[i] = 0;
        }

        return temp;
    }
}
