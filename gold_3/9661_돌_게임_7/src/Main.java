import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long num = Long.parseLong(br.readLine());
        num = num % 5;

        if (num == 0 || num == 2) {
            sb.append("CY");
        } else {
            sb.append("SK");
        }

        System.out.println(sb);
    }
}
