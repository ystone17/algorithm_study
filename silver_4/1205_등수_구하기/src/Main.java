import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, taeSu, p;
    static int[] score, rank;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        taeSu = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        score = new int[p];
        rank = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int idx = n;
        for (int i = 0; i < n; i++) {
            if (score[i] < taeSu) {
                idx = i;
                break;
            }
        }

        if (idx >= p) {
            System.out.println(-1);
            return;
        }

        score[idx] = taeSu;
        rank[0] = 1;
        for (int i = 1; i <= idx; i++) {
            rank[i] = score[i] == score[i - 1] ? rank[i - 1] : i + 1;
        }

        System.out.println(rank[idx]);
    }
}
