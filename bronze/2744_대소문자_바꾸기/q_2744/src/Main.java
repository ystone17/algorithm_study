import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[] chars = br.readLine().toCharArray();

        for (char c : chars) {
            if (c >= 97) {
                sb.append((char) (c - 32));
            } else {
                sb.append((char) (c + 32));
            }
        }

        System.out.println(sb);

    }
}
