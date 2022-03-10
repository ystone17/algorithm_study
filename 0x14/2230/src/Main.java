import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        Arrays.sort(input);

        while (start < n - 1 && end < n) {
            int sub = input[end] - input[start];
            if (sub >= m) {
                start++;
                min = Math.min(min, sub);
            } else {
                end++;
            }
        }
        System.out.println(min);

    }
}
