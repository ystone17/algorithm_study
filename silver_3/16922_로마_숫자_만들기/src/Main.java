import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] romaCount;
    static int[] roma = {1, 5, 10, 50};
    static Set<Integer> res = new HashSet<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        romaCount = new int[4];

        solve(0, 0);

        System.out.println(res.size());
    }

    private static void solve(int idx, int count) {
        if (idx == 3) {
            romaCount[idx] = n - count;

            int total = 0;
            for (int i = 0; i < romaCount.length; i++) {
                total += roma[i] * romaCount[i];
            }

            res.add(total);
            return;
        }

        for (int i = 0; i <= n - count; i++) {
            romaCount[idx] = i;
            solve(idx + 1, count + i);
        }
    }
}
