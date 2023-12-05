import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, a, b, c;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                sb.append(segmentTree.sum(b, c)).append("\n");
            } else {
                segmentTree.update(b, c);
            }
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        long[] tree;
        int[] seq;

        public SegmentTree(int n) {
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2) + 1);
            tree = new long[(int) Math.pow(2, treeHeight)];

            seq = new int[n + 1];
        }

        public long sum(int i, int j) {
            if (i > j) {
                return segmentTreeSum(1, n, 1, j, i);
            }

            return segmentTreeSum(1, n, 1, i, j);
        }

        public void update(int i, int k) {
            segmentTreeUpdate(1, n, 1, i, k - seq[i]);
            seq[i] = k;
        }

        private long segmentTreeSum(int left, int right, int treeIdx, int i, int j) {
            if (right < i || j < left) {
                return 0;
            }

            if (i <= left && right <= j) {
                return tree[treeIdx];
            }

            return segmentTreeSum(left, (left + right) / 2, treeIdx * 2, i, j)
                    + segmentTreeSum((left + right) / 2 + 1, right, treeIdx * 2 + 1, i, j);
        }

        private void segmentTreeUpdate(int left, int right, int treeIdx, int i, int k) {
            if (i < left || right < i) {
                return;
            }

            tree[treeIdx] += k;

            if (left == right) {
                return;
            }

            segmentTreeUpdate(left, (left + right) / 2, treeIdx * 2, i, k);
            segmentTreeUpdate((left + right) / 2 + 1, right, treeIdx * 2 + 1, i, k);
        }
    }
}
