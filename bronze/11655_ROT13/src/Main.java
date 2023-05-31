import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] seq;

    public static void main(String[] args) throws IOException {
        seq = br.readLine().toCharArray();

        for (char c : seq) {
            sb.append(rot13(c));
        }
        System.out.println(sb);

    }

    static char rot13(char ori) {
        if (97 <= ori && ori <= 122) {
            return (char) ((ori - 97 + 13) % 26 + 97);
        }

        if (65 <= ori && ori <= 90) {
            return (char) ((ori - 65 + 13) % 26 + 65);
        }

        return ori;
    }
}
