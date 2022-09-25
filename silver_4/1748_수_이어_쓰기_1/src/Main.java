import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, totalDigit, decimal = 10, digit = 1;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (true) {
            if (n < decimal) {
                totalDigit += (n - (decimal / 10) + 1) * digit;
                break;
            } else {
                totalDigit += (decimal - decimal / 10) * digit;
            }

            decimal *= 10;
            digit += 1;
        }

        System.out.println(totalDigit);
    }
}
