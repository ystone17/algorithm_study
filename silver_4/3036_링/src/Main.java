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

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a, b, gcdNum;

        for (int i = 1; i < n; i++) {
            a = arr[0];
            b = arr[i];

            gcdNum = gcd(a, b);

            a /= gcdNum;
            b /= gcdNum;

            sb.append(String.format("%d/%d\n", a, b));
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }


        while (b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}
