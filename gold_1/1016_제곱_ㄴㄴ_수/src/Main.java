import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long min, max;
    static int[] seq;
    static int answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());

        seq = new int[(int) (max - min) + 1];

//        for (long i = min; i <= max; i++) {
//            check(i);
//        }
        check();
        for (int i : seq) {
            if (i != 1) {
                answer++;
            }
        }
        sb.append(answer);
        System.out.println(sb);


    }

    static void check() {
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long l = min / pow * pow;

            if (l < min) {
                l += pow;
            }

            while (l <= max) {
                seq[(int) (l - min)] = 1;
                l += pow;
            }
        }


    }


}
