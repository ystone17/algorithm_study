import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res = -1, resIdx = -1;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            seq = new int[5];
            for (int j = 0; j < 5; j++) {
                seq[j] = Integer.parseInt(st.nextToken());
            }

            int max = getMax();

            if (res <= max) {
                res = max;
                resIdx = i;
            }
        }


        System.out.println(resIdx);
    }

    private static int getMax() {
        int sum = 0;
        int max = 0;

        for (int a = 0; a < 5; a++) {
            sum += seq[a];
            for (int b = a + 1; b < 5; b++) {
                sum += seq[b];
                for (int c = b + 1; c < 5; c++) {
                    sum += seq[c];
                    max = Math.max(max, sum % 10);
                    sum -= seq[c];
                }
                sum -= seq[b];
            }
            sum -= seq[a];
        }


        return max;
    }
}
