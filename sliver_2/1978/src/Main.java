import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(prime(input)) answer++;
        }

        System.out.println(answer);
    }

    private static boolean prime(int input) {
        if(input == 1) return false;

        for (int j = 2; j <= Math.sqrt(input); j++) {
            if(input % j == 0) return false;
        }
        return true;
    }
}
