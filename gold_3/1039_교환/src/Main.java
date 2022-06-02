import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String number;
    static int[][] dp;
    static int k, answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        number = st.nextToken();
        k = Integer.parseInt(st.nextToken());

        dp = new int[k][1000001];

        dp(0, number);

        System.out.println(answer == 0 ? -1 : answer);
    }

    static void dp(int index, String number) {
        int N = Integer.parseInt(number);
        if (index == k) {
            answer = Math.max(answer, N);
            return;
        }

        if (dp[index][N] != 0) return;

        for (int a = 0; a < number.length() - 1; a++) {
            for (int b = a + 1; b < number.length(); b++) {
                if (a == 0 && number.charAt(b) == '0') continue;
                dp(index + 1, swap(a, b, number));
            }
        }

        dp[index][N] = 1;
    }

    static String swap(int a, int b, String number) {
        char[] chars = number.toCharArray();
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
        return String.valueOf(chars);
    }
}
