import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String s, t;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        t = br.readLine();

        System.out.println(solve(s.length(), t) ? 1 : 0);
    }

    private static boolean solve(int sourceLength, String cur) {
        if (cur.length() == sourceLength) {
            return cur.equals(s);
        }

        var firstChar = cur.charAt(0);
        var lastChar = cur.charAt(cur.length() - 1);

        if (firstChar == 'A' && lastChar == 'A') {
            return solve(sourceLength, cur.substring(0, cur.length() - 1));
        }

        if (firstChar == 'B' && lastChar == 'A') {
            return solve(sourceLength, cur.substring(0, cur.length() - 1)) || solve(sourceLength, new StringBuilder(cur).reverse().substring(0, cur.length() - 1));
        }

        if (firstChar == 'B' && lastChar == 'B') {
            return solve(sourceLength, new StringBuilder(cur).reverse().substring(0, cur.length() - 1));
        }

        return false;
    }


}
