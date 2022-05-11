import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] sort = new int[8001];
    static int n, a, b, c, min, max;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int total = 0;
        int maxCount = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            total += temp;

            sort[temp + 4000]++;
            maxCount = Math.max(maxCount, sort[temp + 4000]);
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }

        a = (int) Math.round((double) total / n);
        int bCnt = 0;
        b = Integer.MIN_VALUE;
        int cCnt = 0;
        for (int i = 0; i < 8001; i++) {
            if(sort[i] == maxCount && cCnt < 2){
                c = i - 4000;
                cCnt++;
            }

            bCnt += sort[i];
            if (bCnt >= n / 2 + 1 && b == Integer.MIN_VALUE) {
                b = i - 4000;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(max - min);
    }
}
