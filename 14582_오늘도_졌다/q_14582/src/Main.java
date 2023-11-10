import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] a = new int[9], b = new int[9];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        boolean isAWin = false;
        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < 9; i++) {
            aSum += a[i];
            if (aSum > bSum) {
                isAWin = true;
            }

            bSum += b[i];
        }

        System.out.println(isAWin ? "Yes" : "No");
    }
}
