import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String binaryStr = br.readLine();

        for (int i = binaryStr.length(); i - 3 >= 0; i -= 3) {
            String substring = binaryStr.substring(i - 3, i);
            sb.append(Integer.parseInt(substring, 2));
        }

        if (binaryStr.length() % 3 != 0) {
            String substring = binaryStr.substring(0, binaryStr.length() % 3);
            sb.append(Integer.parseInt(substring, 2));
        }

        sb.reverse();
        System.out.println(sb);

    }
}
