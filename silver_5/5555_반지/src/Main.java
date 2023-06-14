import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String target;
    static int n, cnt;

    public static void main(String[] args) throws IOException {
        target = br.readLine();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine().repeat(2);
            if(s.contains(target)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
