import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String number = br.readLine();
        int cnt = 0;
        while (number.length() != 1) {
            int n = 0;
            for (char c : number.toCharArray()) {
                n += c - '0';
            }

            while (n != 0) {
                sb.append(n % 10);
                n /= 10;
            }

            cnt++;
            number = sb.reverse().toString();
            sb = new StringBuilder();
        }

        sb.append(cnt).append("\n");
        sb.append(Integer.parseInt(number) % 3 == 0 ? "YES" : "NO");
        System.out.println(sb);

    }
}
