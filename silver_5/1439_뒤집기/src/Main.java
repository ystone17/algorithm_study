import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] input;
    static int[] point = {1, 0};

    public static void main(String[] args) throws IOException {
        input = br.readLine().toCharArray();

        char base = input[0];
        int idx = 0;
        for (char c : input) {
            if (base != c) {
                base = c;
                idx = (idx + 1) % 2;
                point[idx]++;
            }
        }

        sb.append(Math.min(point[0], point[1]));
        System.out.println(sb);
    }
}
