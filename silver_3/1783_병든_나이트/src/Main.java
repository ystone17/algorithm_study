import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int y, x;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        if (y >= 3) {
            if (x < 5) {
                System.out.println(x);
            } else if (x < 7) {
                System.out.println(4);
            } else {
                System.out.println(x - 2);
            }
        } else if (y == 2) {
            System.out.println(Math.min((x + 1) / 2, 4));
        } else {
            System.out.println(1);
        }
    }
}
