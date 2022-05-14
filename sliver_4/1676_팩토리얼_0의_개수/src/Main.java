import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] num = new int[2];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k % 2 == 0) {
                num[0]++;
                k /= 2;
            }

            while (k % 5 == 0) {
                num[1]++;
                k /= 5;
            }
        }

        System.out.println(Math.min(num[0], num[1]));
    }

}
