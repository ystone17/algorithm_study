import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Pos[] a;
    static int[] p;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        a = new Pos[n];
        p = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = new Pos(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            p[a[i].idx] = i;
        }
        for (int i : p) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static class Pos implements Comparable<Pos> {
        int idx;
        int value;

        public Pos(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Pos o) {
            if (value == o.value) {
                return Integer.compare(idx, o.idx);
            } else {
                return Integer.compare(value, o.value);
            }
        }
    }
}
