import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] input;
    static int[] count;
    static List<BunSu> bunSuList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }

        input = new int[n][4];
        count = new int[n];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            count[input[i][0]]++;
            count[input[i][1]]++;
        }

        for (int i = 0; i < n; i++) {
            bunSuList.add(new BunSu());
        }

        int base = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                base = i;
                break;
            }
        }

        int done = 0;
        count = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int a = input[i][0];
            int b = input[i][1];
            int c = input[i][2];
            int d = input[i][3];
            if (a == base) {
                bunSuList.get(b).bunJa = d;
                bunSuList.get(b).bunMo = c;
                bunSuList.get(b).counterNum = a;
                count[b] = 1;
                done++;
            }

            if (b == base) {
                bunSuList.get(a).bunJa = c;
                bunSuList.get(a).bunMo = d;
                bunSuList.get(a).counterNum = b;
                count[a] = 1;
                done++;
            }
        }

        while (done < n) {
            for (int i = 0; i < n - 1; i++) {
                int a = input[i][0];
                int b = input[i][1];
                int c = input[i][2];
                int d = input[i][3];

                if (count[a] == 0 && bunSuList.get(b).counterNum == base) {
                    bunSuList.get(a).bunJa = bunSuList.get(b).bunJa * c;
                    bunSuList.get(a).bunMo = bunSuList.get(b).bunMo * d;
                    bunSuList.get(a).counterNum = base;
                    count[a] = 1;
                    done++;
                    break;
                }

                if (count[b] == 0 && bunSuList.get(a).counterNum == base) {
                    bunSuList.get(b).bunJa = bunSuList.get(a).bunJa * d;
                    bunSuList.get(b).bunMo = bunSuList.get(a).bunMo * c;
                    bunSuList.get(b).counterNum = base;
                    count[b] = 1;
                    done++;
                    break;
                }
            }
        }

        for (BunSu bunSu : bunSuList) {
            bunSu.yakBun();
        }

        long x = 1;

        for (BunSu bunSu : bunSuList) {
            x = lcm(x, bunSu.bunMo);
        }

        for (int i = 0; i < bunSuList.size(); i++) {
            if (i == base) {
                sb.append(x).append(" ");
                continue;
            }

            sb.append(bunSuList.get(i).bunJa * x / bunSuList.get(i).bunMo).append(" ");
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static class BunSu {
        long bunJa = 1;
        long bunMo = 1;
        int counterNum;

        public BunSu() {
            this.counterNum = -1;
        }

        public void yakBun() {
            long gcd = gcd(bunJa, bunMo);
            bunJa /= gcd;
            bunMo /= gcd;
        }
    }
}
