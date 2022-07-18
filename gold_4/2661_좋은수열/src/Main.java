import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static String answer;
    static String[] number = {"1", "2", "3"};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dfs(0, "");
        System.out.println(answer);
    }

    private static boolean dfs(int idx, String s) {
        if (idx == n) {
            answer = s;
            return true;
        }

        for (String num : number) {
            String nS = s.concat(num);
            if (check(nS)) {
                boolean dfs = dfs(idx + 1, nS);
                if (dfs) return true;
            }
        }

        return false;
    }

    private static boolean check(String s) {

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.substring(s.length() - i * 2, s.length() - i).equals(s.substring(s.length() - i))) {
                return false;
            }
        }

        return true;
    }


}
