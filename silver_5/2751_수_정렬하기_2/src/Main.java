import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] counting = new int[2000001];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            counting[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        for (int i = 0; i < counting.length; i++) {
            for (int j = 0; j < counting[i]; j++) {
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.println(sb);
    }
}
