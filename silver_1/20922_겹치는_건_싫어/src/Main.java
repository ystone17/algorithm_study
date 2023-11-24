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

    static final int MAX_NUM = 100_000;

    static int n, k;
    static int[] seq;
    static Map<Integer, Integer> countByNum = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int left = 0;
        int right = 0;
        countByNum.put(seq[0], 1);

        while (right < n - 1) {

            var count = countByNum.getOrDefault(seq[right + 1], 0);

            if (count + 1 <= k) {
                right++;
                countByNum.put(seq[right], count + 1);
                max = Math.max(max, right - left + 1);
                continue;
            }

            countByNum.put(seq[left], countByNum.get(seq[left]) - 1);
            left++;
        }

        System.out.println(max);
    }

    static boolean ok(int mid) {
        boolean isOk;
        for (int i = 1; i <= n - mid + 1; i++) {
            isOk = true;
            countByNum.clear();

            for (int j = i; j < i + mid; j++) {
                var count = countByNum.getOrDefault(seq[j], 0);
                if (count + 1 > k) {
                    isOk = false;
                    break;
                }
                countByNum.put(seq[j], count + 1);
            }
            if (isOk) {
                return true;
            }
        }

        return false;
    }
}
