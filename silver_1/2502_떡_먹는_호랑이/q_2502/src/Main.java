import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int d, k;
    static int[][] pibo;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pibo = new int[d + 1][2];
        pibo[1][0] = 1;
        pibo[1][1] = 0;

        pibo[2][0] = 0;
        pibo[2][1] = 1;

        for (int i = 3; i <= d; i++) {
            pibo[i][0] = pibo[i-1][0] + pibo[i-2][0];
            pibo[i][1] = pibo[i-1][1] + pibo[i-2][1];
        }

        for (int a = 1; a <= 100000; a++) {
            int temp = k - a * pibo[d][0];
            if(temp > 0 && temp % pibo[d][1] == 0 ){
                System.out.println(a);
                System.out.println(temp / pibo[d][1]);
                return;
            }
        }
    }
}
