import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, answer;
    static String[] inputs;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 4) {
            System.out.println(0);
            return;
        }

        k -= 5;

        alpha = new int[26];
        alpha['a' - 'a'] = 1;
        alpha['n' - 'a'] = 1;
        alpha['t' - 'a'] = 1;
        alpha['i' - 'a'] = 1;
        alpha['c' - 'a'] = 1;

        inputs = new String[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            inputs[i] = input.substring(4, input.length() - 4);
        }

        combi(0, 0);

        System.out.println(answer);
    }

    static void combi(int idx, int cnt) {
        if (cnt == k) {
            int res = 0;
            for (String input : inputs) {
                boolean ok = true;
                for (char c : input.toCharArray()) {
                    if(alpha[c - 'a'] == 0){
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    res++;
                }
            }

            answer = Math.max(answer, res);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (alpha[i] == 1) continue;
            alpha[i] = 1;
            combi(i + 1, cnt + 1);
            alpha[i] = 0;
        }


    }
}
