import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] arr, temp, used;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        used = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bf(0));


    }

    static int bf(int idx) {
        if (idx == n) {
            return IntStream.range(1,n).map(j -> Math.abs(temp[j] - temp[j - 1])).sum();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            temp[idx] = arr[i];
            res = Math.max(res, bf(idx + 1));
            used[i] = 0;
        }

        return res;
    }


}
