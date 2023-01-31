import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String s;
    static char[] ucpc = {'U', 'C', 'P', 'C'};

    public static void main(String[] args) throws IOException {
        s = br.readLine();

        int idx = 0;

        for (char c : s.toCharArray()) {
            if(idx == 4) break;
            if(c == ucpc[idx]) {
                idx++;
            }
        }

        if(idx >= 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
