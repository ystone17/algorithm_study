import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] numbers = br.readLine().toCharArray();

            if (numbers[0] == '0') break;

            boolean yes = true;
            for (int i = 0; i < numbers.length / 2; i++) {
                if (numbers[i] != numbers[numbers.length - 1 - i]) {
                    yes = false;
                    break;
                }
            }

            if (yes) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);


    }
}
