import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer= 0;

        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            answer += i * i % 10;
        }

        System.out.println(answer % 10);

    }
}


