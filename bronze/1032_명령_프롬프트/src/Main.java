import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static String[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        seq = new String[n];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = br.readLine();
        }

        for (int i = 0; i < seq[0].length(); i++) {
            boolean isSame = true;
            char base = seq[0].charAt(i);

            for (String s : seq) {
                if(base != s.charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) {
                sb.append(base);
                continue;
            }

            sb.append("?");
        }

        System.out.println(sb);
    }
}
