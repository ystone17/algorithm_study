import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, d, k, c, count, res;
    static int[] arr, eat;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        eat = new int[d + 1];
        for (int i = 0; i < k; i++) {
            eat[arr[i]]++;
            if (eat[arr[i]] == 1) {
                count++;
            }
        }
        if (eat[c] == 0) {
            count++;
        }

        res = count;

        for (int i = 0; i < n; i++) {
            var left = arr[i];
            var right = arr[(i + k) % n];

            eat[left]--;
            if (eat[left] == 0) {
                count--;

                if (left == c) {
                    count++;
                }
            }


            eat[right]++;
            if (eat[right] == 1) {
                count++;

                if (right == c) {
                    count--;
                }
            }

            res = Math.max(res, count);
        }

        System.out.println(res);
    }
}
