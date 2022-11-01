import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, cnt;
    static boolean[] used;
    static int[] input;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        used = new boolean[n + 1];
        input = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        re(1);
        if(cnt == 1) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void re(int idx) {
        if (idx > n) {
            cnt++;
            sb = new StringBuilder();
            for (int i = 1; i < input.length; i++) {
                sb.append(input[i]).append(" ");
            }
            input[idx - 1] = n;
            return;
        }

        for (int i = input[idx]; i > 0; i--) {
            if (used[i]) continue;
            used[i] = true;
            input[idx] = i;
            re(idx + 1);
            if (cnt == 2) return;
            used[i] = false;
        }
        input[idx - 1] = n;
    }
}