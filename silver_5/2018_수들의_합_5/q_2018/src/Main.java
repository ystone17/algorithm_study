import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int num, cnt;

    public static void main(String[] args) throws IOException {
        num = Integer.parseInt(br.readLine());

        int n = 1;

        while (true) {
            int z = num - ((n - 1) * n / 2);
            int a = z / n;
            if (a <= 0) break;
            if (z % n == 0) cnt++;
            n++;
        }

        System.out.println(cnt);


    }
}
