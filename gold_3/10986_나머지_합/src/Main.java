import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int size, M, sum;
    static long answer;
    static int[] cnt = new int[1001];

    public static void main(String[] args) throws IOException {


        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(st.nextToken());
            sum %= M;
            cnt[sum]++;
        }

        for (int j : cnt) {
            answer += (long) j * (j - 1) / 2;
        }

        System.out.println(answer + cnt[0]);
    }
}
