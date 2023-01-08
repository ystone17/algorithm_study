import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, taeSu, p;
    static List<Integer> score = new ArrayList<>();
    static int[] rank;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        taeSu = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score.add(Integer.parseInt(st.nextToken()));
        }
        score.sort(Collections.reverseOrder());

        rank = new int[n];
        rank[0] = 1;
        for (int i = 1; i < n; i++) {
            if (Objects.equals(score.get(i - 1), score.get(i))) {
                rank[i] = rank[i - 1];
            } else {
                rank[i] = i + 1;
            }
        }

        int idx = p;
        for (int i = 0; i < n; i++) {
            if (score.get(i) < taeSu) {
                idx = i;
            }
        }

        if (idx > p) {
            System.out.println(-1);
            return;
        }

        if (idx > n - 1) {
            System.out.println(idx);
            return;
        }

        System.out.println(rank[p]);

    }
}
