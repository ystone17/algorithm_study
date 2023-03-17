import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, res;

    static int[] baseAlpha, targetAlpha;

    public static void main(String[] args) throws IOException {
        baseAlpha = new int[26];
        n = Integer.parseInt(br.readLine());

        String base = br.readLine();
        for (char c : base.toCharArray()) {
            baseAlpha[c - 'A']++;
        }

        for (int i = 0; i < n - 1; i++) {
            String target = br.readLine();
            if (isSame(target)) res++;
        }

        System.out.println(res);
    }

    private static boolean isSame(String target) {
        targetAlpha = new int[26];

        for (char c : target.toCharArray()) {
            targetAlpha[c - 'A']++;
        }

        int a = 0;
        int b = 0;

        for (int i = 0; i < 26; i++) {
            if (baseAlpha[i] - targetAlpha[i] > 0) {
                a += baseAlpha[i] - targetAlpha[i];
            } else {
                b += targetAlpha[i] - baseAlpha[i];
            }
        }

        return a <= 1 && b <= 1;
    }
}
