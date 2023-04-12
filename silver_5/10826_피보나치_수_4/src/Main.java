import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static List<BigInteger> pibo = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        pibo.add(BigInteger.ZERO);
        pibo.add(BigInteger.ONE);

        for (int i = 2; i <= 10000; i++) {
            pibo.add(pibo.get(i - 1).add(pibo.get(i - 2)));
        }

        n = Integer.parseInt(br.readLine());
        System.out.println(pibo.get(n));
    }
}
