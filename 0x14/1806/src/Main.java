import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int si = 0, ei = 0;

        int len = Integer.MAX_VALUE;
        int sum = arr[0];

        while (si < n && ei < n) {
            if (sum < s) {
                ei++;
                if (ei == n) continue;
                sum += arr[ei];
            } else {
                len = Math.min(len, ei - si + 1);
                sum -= arr[si++];
            }
        }

        if (len == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(len);
        }
    }


}




