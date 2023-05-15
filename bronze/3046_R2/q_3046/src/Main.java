import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        System.out.println(s * 2 - r1);
    }
}
