import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, y, total;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            total += Integer.parseInt(br.readLine());
        }

        x = total / 60;
        y = total % 60;

        System.out.println(x);
        System.out.println(y);
    }
}
