import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long l, num, idx;

    public static void main(String[] args) throws IOException {
        l = Long.parseLong(br.readLine());

        while (num < l) {
            num += ++idx;
        }
        if (num == l) {
            System.out.println(idx);
        } else {
            System.out.println(idx - 1);
        }

    }
}
