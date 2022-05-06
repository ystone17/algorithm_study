import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int tc, n, answer;
    static int[] next, visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            answer = 0;

            n = Integer.parseInt(br.readLine());
            next = new int[n + 1];
            visited = new int[n + 1];
            finished = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                next[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            sb.append(n - answer).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int k) {
        if(visited[k] == 1) return;

        visited[k] = 1;

        if(visited[next[k]]== 0){
            dfs(next[k]);
        } else {
            if(!finished[next[k]]){
                answer++;
                for (int i = next[k]; i != k; i = next[i]) {
                    answer++;
                }
            }
        }

        finished[k] = true;

    }


}
