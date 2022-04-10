import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int res = 0;

        for (int a = 0; a <= arr.length - 3; a++) {
            for (int b = a+1; b <= arr.length - 2; b++) {
                for (int c = b + 1; c <= arr.length - 1; c++) {
                    int sum = arr[a] + arr[b] + arr[c];
                    if (sum > m ) continue;
                    res = Math.max(res, sum);
                }
            }
        }


        System.out.println(res);

    }
}
