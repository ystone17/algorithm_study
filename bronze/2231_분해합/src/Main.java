import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n ; i++) {
            int temp = i;
            int res = i;
            while (temp > 0){
                res += temp % 10;
                temp /= 10;
            }
            if (res == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
