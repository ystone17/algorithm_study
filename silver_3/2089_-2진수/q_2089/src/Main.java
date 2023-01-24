import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, a = -2;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        while (n != 0) {
            int b = 0;
            if (n < 0) {
                int mod;
                while (true) {
                    mod = n - a * b;
                    if (mod == 0 || mod == 1) break;
                    b++;
                }

                sb.append(mod);
            } else {
                int mod;
                while (true) {
                    mod = n - a * b;
                    if (mod == 0 || mod == 1) break;
                    b--;
                }

                sb.append(mod);
            }
            n = b;
        }

        sb.reverse();
        System.out.println(sb);
    }
}
