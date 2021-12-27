import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] durability, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        durability = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        int res = Break(0);
        System.out.println(res);

    }

    static int Break(int eggIndex) {
        if (eggIndex == n) {
            int res = 0;
            for (int d : durability) {
                if (d <= 0) res++;
            }
            return res;
        }

        if (durability[eggIndex] <= 0) {
            return Break(eggIndex + 1);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (i == eggIndex) continue;
            if (durability[i] > 0) {
                durability[i] -= weight[eggIndex];
                durability[eggIndex] -= weight[i];
                int r = Break(eggIndex + 1);
                if (res < r) res = r;
                durability[i] += weight[eggIndex];
                durability[eggIndex] += weight[i];
            } else {
                int r = Break(eggIndex + 1);
                if (res < r) res = r;
            }
        }
        return res;
    }
}
