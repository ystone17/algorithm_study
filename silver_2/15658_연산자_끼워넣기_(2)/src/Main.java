import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] seq;
    static int[] op = new int[4];
    static int[] opUsed = new int[4];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        Res req = req(1, new Res(seq[0], seq[0]));
        System.out.println(req.max);
        System.out.println(req.min);
    }

    static Res req(int idx, Res res) {
        if (idx >= n) {
            return res;
        }

        Res temp = new Res(Integer.MIN_VALUE, Integer.MAX_VALUE);

        if (opUsed[0] < op[0]) {
            opUsed[0]++;
            Res add = req(idx + 1, res.add(seq[idx]));

            temp.max = Math.max(temp.max, add.max);
            temp.min = Math.min(temp.min, add.min);
            opUsed[0]--;
        }

        if (opUsed[1] < op[1]) {
            opUsed[1]++;
            Res minus = req(idx + 1, res.minus(seq[idx]));

            temp.max = Math.max(temp.max, minus.max);
            temp.min = Math.min(temp.min, minus.min);
            opUsed[1]--;
        }

        if (opUsed[2] < op[2]) {
            opUsed[2]++;
            Res mul = req(idx + 1, res.mul(seq[idx]));

            temp.max = Math.max(temp.max, mul.max);
            temp.min = Math.min(temp.min, mul.min);
            opUsed[2]--;
        }

        if (opUsed[3] < op[3]) {
            opUsed[3]++;
            Res div = req(idx + 1, res.div(seq[idx]));

            temp.max = Math.max(temp.max, div.max);
            temp.min = Math.min(temp.min, div.min);
            opUsed[3]--;
        }

        return temp;
    }

    static class Res {
        int max;
        int min;

        public Res(int max, int min) {
            this.max = max;
            this.min = min;
        }

        Res add(int i) {
            return new Res(max + i, min + i);
        }

        Res minus(int i) {
            return new Res(max - i, min - i);
        }

        Res mul(int i) {
            return new Res(max * i, min * i);
        }

        Res div(int i) {
            return new Res( max / i, min / i);
        }
    }

}
