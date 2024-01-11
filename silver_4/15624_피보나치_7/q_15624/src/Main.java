import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] seq = new int[1000001];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        seq[1] = 1;
        for (int i = 2; i < seq.length; i++) {
            seq[i] = (seq[i - 1] + seq[i - 2]) % 1000000007;
        }

        System.out.println(seq[n]);
    }
}
