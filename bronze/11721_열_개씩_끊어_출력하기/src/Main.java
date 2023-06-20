import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] charSeq;

    public static void main(String[] args) throws IOException {
        charSeq = br.readLine().toCharArray();

        for (int i = 0; i < charSeq.length; i++) {
            sb.append(charSeq[i]);
            if(i % 10 == 9) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
