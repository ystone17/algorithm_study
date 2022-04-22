import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();
        long hash = 0;

        for (int i = 0; i < chars.length; i++) {
            int temp = chars[i] - 'a' + 1;

            for (int j = 0; j < i; j++) {
                temp = (temp % 1234567891) * 31;
            }
            hash += temp % 1234567891;
        }

        System.out.println(hash);
    }
}
