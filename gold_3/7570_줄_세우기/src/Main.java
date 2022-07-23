import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] arr;
    static int[] checkLen;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        checkLen = new int[n+ 1];
        int max = 0;

        for (int i : arr) {
            checkLen[i] = checkLen[i - 1] + 1;
            max = Math.max(max, checkLen[i]);
        }

        System.out.println(n - max);
    }
}
