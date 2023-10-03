import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res;
    static int[] seq;
    static Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                map.put(seq[a] + seq[b], true);
            }
        }

        for (int i : seq) {
            if (map.containsKey(i)) {
                res++;
            }
        }

        System.out.println(res);
    }
}
