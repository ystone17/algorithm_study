import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, d, k, c, temp, res;
    static int[] plate;
    static boolean[] isEat;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        plate = new int[n];
        for (int i = 0; i < n; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            isEat = new boolean[d + 1];
            temp = 0;
            for (int j = 0; j < k; j++) {
                int idx = (i + j) % n;
                if (isEat[plate[idx]]) continue;
                isEat[plate[idx]] = true;
                temp++;
            }

            if (!isEat[c]) temp++;
            res = Math.max(res, temp);
        }

        System.out.println(res);
    }
}
