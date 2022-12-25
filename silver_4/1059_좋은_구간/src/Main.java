import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        k = Integer.parseInt(br.readLine());

        int min = 1, max = 1000;
        for (int i : arr) {
            if (i < k) {
                min = i + 1;
            }

            if (i > k) {
                max = i - 1;
                break;
            }

            if (i == k) {
                System.out.println(0);
                return;
            }
        }

        long sum = 0;
        for (int i = min; i < k; i++) {
            sum += max - k + 1;
        }
        sum += max - k;
        System.out.println(sum);


    }
}
