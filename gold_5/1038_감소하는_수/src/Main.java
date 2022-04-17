import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, count = -2;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long[] aaa = new long[1023];
        for (int i = 1; i <= 1023; i++) {
            long num = 0;
            int temp = i;
            for (int idx = 9; idx >= 0; idx--) {
                if(temp % 2 == 1) num = num * 10 + idx;
                temp /= 2;
            }
            aaa[i - 1] = num;
        }
        Arrays.sort(aaa);

        if(n > 1022) System.out.println(-1);
        else{
            System.out.println(aaa[n]);
//            solve(10,10, "");
//            System.out.println(answer);
        }


    }

    static void solve(int depth, int end, String num) {
        if (depth == num.length()) {
            count++;
            if(count == n) answer = Long.parseLong(num);
            return;
        }

        for (int i = 0; i < end; i++) {
            if(i == 0 && num.length() ==0) solve(depth-1, 10, num);
            solve(depth, i, num + i);
        }

    }
}
