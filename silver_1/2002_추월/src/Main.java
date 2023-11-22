import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res;
    static Map<String, Integer> numbering = new HashMap<>();
    static int[] seq, partMin;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int idx = 1;
        for (int i = 0; i < n; i++) {
            numbering.put(br.readLine(), idx++);
        }

        seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = numbering.get(br.readLine());
        }

        partMin = new int[n];
        partMin[n - 1] = seq[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            partMin[i] = Math.min(partMin[i + 1], seq[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (seq[i] > partMin[i + 1]) {
                res++;
            }
        }

        System.out.println(res);
    }
}
