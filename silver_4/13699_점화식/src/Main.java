import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[] arr = new long[36];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr[0] = 1;
        for (int i = 1; i <= 35; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - 1 - j];
            }
        }

        System.out.println(arr[n]);
    }
}
