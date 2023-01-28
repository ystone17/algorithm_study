import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int num = 0;

        while (n > max) {
            max += num++;
        }

        int a, b;

        if ((num - 1) % 2 == 0) {
            a = num - 1;
            b = 1;
            while (n != max) {
                a--;
                b++;
                max--;
            }
        } else {
            a = 1;
            b = num - 1;
            while (n != max) {
                a++;
                b--;
                max--;
            }
        }

        System.out.printf("%d/%d", a, b);
    }
}
