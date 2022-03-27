import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] twoN = new int[1001];

        twoN[1] = 1;
        twoN[2] = 3;

        for (int i = 3; i < 1001; i++) {
            twoN[i] = (twoN[i - 1] + twoN[i - 2] * 2) % 10007;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(twoN[Integer.parseInt(br.readLine())]);

    }
}
