import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, a, b, aTemp, bTemp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        b = 1;

        for (int i = 0; i < n - 1; i++) {
            bTemp = a + b;
            aTemp = b;

            a = aTemp;
            b = bTemp;
        }

        System.out.printf("%d %d", a, b);

    }
}
