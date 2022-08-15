import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, idx;
    static int[] used;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        used = new int[n + 1];
        answer = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        req(1);
        if(idx == 1){
            System.out.println(-1);
        } else{
            System.out.println(sb);
        }
    }

    static void req(int i) {
        if (i > n) {
            addPrint();
            answer[i - 1] = 1;
            idx++;
            return;
        }

        for (int j = answer[i]; j < n + 1; j++) {
            if (used[j] == 1) continue;
            used[j] = 1;
            answer[i] = j;
            req(i + 1);
            if(idx >= 2) return;
            used[j] = 0;
        }
        answer[i - 1] = 1;
    }

    static void addPrint() {
        sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        sb.append("\n");
    }
}
