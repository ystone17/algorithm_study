import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static List<Integer> r = new ArrayList<>();
    static List<Integer> c = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < m; i++) {
            r.add(n - i);
            c.add(i + 1);
        }

        for (int i = 0; i < c.size(); i++) {

            for (int k = 0; k < r.size(); k++) {
                if(c.get(i) == 1) break;

                while (true){
                    int gcd = gcd(c.get(i), r.get(k));
                    if(gcd == 1) break;
                    r.set(k, r.get(k) / gcd);
                    c.set(i, c.get(i) / gcd);
                }
            }
        }

        BigInteger answer = BigInteger.ONE;
        for (Integer next : r) {
            answer = answer.multiply(BigInteger.valueOf(next));
        }

        System.out.println(answer);
    }

    static int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
