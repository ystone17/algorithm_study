import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] points;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(points);

        long trash = Math.round((double) n * 0.15);

        double total = 0;
        for (int i = (int) trash; i < n - trash; i++) {
            total += points[i];
        }

        total = (int) Math.round(total / (n - 2 * trash));
        System.out.println((int) total);
    }
}
