import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int tc, n, answer, c;
    static int[] next, discovered;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            answer = 0;
            c = 1;
            n = Integer.parseInt(br.readLine());
            next = new int[n + 1];
            discovered = new int[n + 1];
            finished = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                next[i] = Integer.parseInt(st.nextToken());
            }

//            for (int i = 1; i <= n; i++) {
//                dfs(i);
//            }

            for (int i = 1; i <= n; i++) {
                if (finished[i]) continue;
                dfs_2(i);
            }

            sb.append(n - answer).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int k) {
        if (discovered[k] == 1) return;

        discovered[k] = 1;

        if (discovered[next[k]] == 0) {
            dfs(next[k]);
        } else {
            if (!finished[next[k]]) {
                answer++;
                for (int i = next[k]; i != k; i = next[i]) {
                    answer++;
                }
            }
        }

        finished[k] = true;

    }

    static void dfs_2(int k) {

        discovered[k] = c++;

        if (discovered[next[k]] == 0) {
            dfs_2(next[k]);
        } else if (!finished[next[k]]) {
            answer += discovered[k] - discovered[next[k]] + 1;
        }

        finished[k] = true;

    }


}
