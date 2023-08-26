import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] seq;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(seq);

        for (int i : seq) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
