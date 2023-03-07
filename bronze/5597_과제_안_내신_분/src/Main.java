import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] seq = new int[31];

        for (int i = 0; i < 28; i++) {
            seq[Integer.parseInt(br.readLine())] = 1;
        }

        for (int i = 1; i < seq.length; i++) {
            if (seq[i] == 0) {
                System.out.println(i);
            }
        }

    }
}
