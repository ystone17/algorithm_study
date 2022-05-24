import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String s, p;
    static int[] partialMatch;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        p = br.readLine();

        partialMatch = new int[p.length()];

        setPartialMatch();
        System.out.println(KMP());

    }

    static void setPartialMatch() {
        int begin = 1, matched = 0;

        while (begin + matched < p.length()) {

            if (p.charAt(begin + matched) == p.charAt(matched)) {
                matched++;
                partialMatch[begin + matched - 1] = matched;
            } else {
                if (matched == 0) begin++;
                else {
                    begin = begin + matched - partialMatch[matched - 1];
                    matched = partialMatch[matched - 1];
                }
            }
        }
    }

    static int KMP() {
        int begin = 0, matched = 0;

        while (begin <= s.length() - p.length()) {
            if (matched < p.length() && s.charAt(begin + matched) == p.charAt(matched)) {
                matched++;

                if (matched == p.length()) return 1;
            } else {
                if (matched == 0) begin++;
                else {
                    begin = begin + matched - partialMatch[matched - 1];
                    matched = partialMatch[matched - 1];
                }
            }
        }
        return 0;
    }


}
