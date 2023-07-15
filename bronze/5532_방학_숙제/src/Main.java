import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int l, a, b, c, d;

    public static void main(String[] args) throws IOException {
        l = Integer.parseInt(br.readLine());
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());

        System.out.print((int) (l - Math.max(Math.ceil((double) a / c), Math.ceil((double) b / d))));
    }
}
