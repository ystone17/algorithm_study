import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long a,b;
    static long[] numberOneCount = new long[55];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        numberOneCount[0] = 1;
        for (int i = 1; i < 55; i++) {
            numberOneCount[i] = 2 * numberOneCount[i-1] + (1L << i);
        }
        System.out.println(get(b) - get(a - 1));
    }

    static long get(long k){
        long ans = k & 1;

        for (int i = 54; i > 0; i--) {
            if( (k & (1L << i)) > 0L  ){
                ans+= numberOneCount[i - 1] + (k - (1L << i) + 1);
                k -= (1L << i);
            }
        }
        return ans;
    }
}
