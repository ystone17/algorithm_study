import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        int left;
        int right;
        int sum;

        for (int i = 0; i < seq.length; i++) {
            left = 0;
            right = seq.length - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }

                if (right == i) {
                    right--;
                    continue;
                }
                sum = seq[left] + seq[right];
                if (sum == seq[i]) {
                    res++;
                    break;
                }
                if (sum < seq[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(res);
    }
}
