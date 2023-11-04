import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[] lines;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        lines = new int[n];

        for (int i = 0; i < n; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);
        int sum = -1;
        for (int i = lines.length - 1; i >= 2; i--) {
            if(lines[i] >= lines[i-1] + lines[i-2]) {
                continue;
            }

            sum = lines[i] + lines[i - 1] + lines[i - 2];
            break;
        }

        System.out.println(sum);
    }
}
