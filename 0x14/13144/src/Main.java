import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static long[] numbers = new long[100001];
    static long[] visited = new long[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        numbers[1] = 1;
        for (int i = 2; i < 100001; i++) {
            numbers[i] = numbers[i - 1] + i;
        }

        BigInteger answer = BigInteger.ZERO;

        int s = 0, e = 0;
        int len = 0;


        while (e <= n) {
            if (e != n &&  visited[arr[e]] == 0 ) {
                visited[arr[e++]] = 1;
                len++;
                answer = answer.add(BigInteger.valueOf(numbers[len] - numbers[len - 1]));
                continue;
            }
            visited[arr[s++]] = 0;
            len--;

            if (e == n) break;
        }

        System.out.println(answer);

    }
}
