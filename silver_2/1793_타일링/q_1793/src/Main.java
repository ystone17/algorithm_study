import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<BigInteger> dp = new ArrayList<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        dp.add(BigInteger.ONE);
        dp.add(BigInteger.ONE);
        dp.add(BigInteger.valueOf(3));
        for (int i = 3; i <= 250; i++) {
            dp.add(dp.get(i - 1).add(dp.get(i - 2).multiply(BigInteger.TWO)));
        }

        String input;
        while ((input = br.readLine()) != null) {
            sb.append(dp.get(Integer.parseInt(input))).append("\n");
        }

        System.out.println(sb);
    }
}
