import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] countingSort = new int[1000000 * 2 + 1];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());

            countingSort[input + 1000000]++;
        }

        for (int i = 0; i < countingSort.length; i++) {
            for (int j = 0; j < countingSort[i]; j++) {
                sb.append(i - 1000000).append("\n");
            }
        }
        System.out.println(sb);
    }
}
