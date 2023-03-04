import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, res;
    static char[] seq;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seq = br.readLine().toCharArray();

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == 'P') {
                for (int j = Math.max(i - k, 0) ; j <= i + k && j < seq.length; j++) {
                    if(seq[j] == 'H') {
                        res++;
                        seq[j] = 'X';
                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
