import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String a, b;
    static int res;

    public static void main(String[] args) throws IOException {
        a = br.readLine();
        b = br.readLine();

        int idx = 0;
        while (idx < a.length()) {
            int x = a.indexOf(b, idx);
            if (x == -1) break;

            idx = x + b.length();
            res++;
        }

        System.out.println(res);
    }
}
