import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[] line, square;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(4);
            return;
        }

        if(n == 2) {
            System.out.println(6);
            return;
        }

        line = new long[n];
        square = new long[n];

        line[0] = 1;
        line[1] = 1;
        square[0] = 4;
        square[1] = 6;

        for (int i = 2; i < n; i++) {
            line[i] = line[i - 1] + line[i - 2];
            square[i] = square[i-1] + line[i] * 2;
        }

        System.out.println(square[n-1]);
    }
}
