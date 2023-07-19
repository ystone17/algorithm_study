import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sbTemp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String s;

        while (true) {
            s = br.readLine();
            if(s.equals("END")) break;

            sbTemp = new StringBuilder();
            sb.append(sbTemp.append(s).reverse()).append("\n");
        }

        System.out.println(sb);
    }
}
