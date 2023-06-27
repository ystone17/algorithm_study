import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long n;

    public static void main(String[] args) throws IOException {
        n = Long.parseLong(br.readLine());

        if(n % 2 == 0) {
            System.out.println("CY");
            return;
        }

        System.out.println("SK");
    }
}
