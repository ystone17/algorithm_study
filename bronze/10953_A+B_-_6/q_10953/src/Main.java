import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] split = br.readLine().split(",");
            sb.append(Integer.parseInt(split[0]) + Integer.parseInt(split[1])).append("\n");
        }

        System.out.println(sb);
    }
}
