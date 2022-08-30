import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String s;

    public static void main(String[] args) throws IOException {
        s = br.readLine() + " ";

        StringBuilder temp = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == ' ') {
                temp.reverse();
                sb.append(temp).append(' ');
                temp = new StringBuilder();
            } else if (c == '<') {
                if (temp.length() != 0) {
                    temp.reverse();
                    sb.append(temp);
                    temp = new StringBuilder();
                }
                while (true) {
                    temp.append(c);
                    if (c == '>') {
                        sb.append(temp);
                        temp = new StringBuilder();
                        break;
                    }
                    c = s.charAt(++idx);
                }
            } else {
                temp.append(c);
            }
            idx++;
        }
        System.out.println(sb);
    }
}
