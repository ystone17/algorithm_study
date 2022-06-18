import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long min = Long.MAX_VALUE;
    static long[] liquid;
    static int l, r, e;
    static long[] answer = new long[3];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        liquid = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);

        for (int i = 0; i < n; i++) {
            tPtr(i);
        }

        Arrays.sort(answer);
        System.out.printf("%d %d %d", answer[0], answer[1], answer[2]);
    }

    static void tPtr(int except) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (left == except) {
                left++;
                continue;
            }
            if (right == except) {
                right--;
                continue;
            }

            long sum = liquid[left] + liquid[right] + liquid[except];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = liquid[left];
                answer[1] = liquid[right];
                answer[2] = liquid[except];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

}
