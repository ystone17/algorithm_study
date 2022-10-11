import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, a, b;
    static int[] seq;
    static MinMax[] Tree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[n];
        Tree = new MinMax[getTreeSize(n)];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        init(0, n - 1, 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;

            MinMax res = find(0, seq.length - 1, 1, a, b);
            sb.append(res.min).append(" ").append(res.max).append("\n");
        }

        System.out.println(sb);
    }

    static int getTreeSize(int size) {
        int h = (int) Math.ceil(Math.log(size) / Math.log(2));
        return (int) Math.pow(2, h + 1);
    }

    static MinMax init(int start, int end, int treeIdx) {
        if (start == end) {
            return Tree[treeIdx] = new MinMax(seq[start], seq[start]);
        }

        int mid = (start + end) / 2;

        MinMax left = init(start, mid, treeIdx * 2);
        MinMax right = init(mid + 1, end, treeIdx * 2 + 1);

        return Tree[treeIdx] = new MinMax(Math.min(left.min, right.min), Math.max(left.max, right.max));
    }

    static MinMax find(int start, int end, int treeIdx, int left, int right) {
        if (left > end || right < start) {
            return null;
        }

        if (left <= start && end <= right) {
            return Tree[treeIdx];
        }

        int mid = (start + end) / 2;

        MinMax l = find(start, mid, treeIdx * 2, left, right);
        MinMax r = find(mid + 1, end, treeIdx * 2 + 1, left, right);

        if (l == null) {
            return r;
        } else if (r == null) {
            return l;
        } else {
            return new MinMax(Math.min(l.min, r.min), Math.max(l.max, r.max));
        }
    }


    static class MinMax {
        int min;
        int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}
