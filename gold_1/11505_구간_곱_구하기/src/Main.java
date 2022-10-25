import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k;

    static int[] seq;
    static long[] segmentTree;
    static long[][] temp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int segmentTreeSize = (int) Math.pow(2, h + 1);
        segmentTree = new long[segmentTreeSize];

        initSegmentTree(1, 0, n - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                changeSegmentTree(1, 0, n - 1, b - 1, c);
                seq[b - 1] = c;
            } else {
                sb.append(getPartitionMul(1, 0, n - 1, b - 1, c - 1)).append("\n");
            }
        }

        System.out.println(sb);

    }

    static long initSegmentTree(int treeIdx, int from, int to) {
        if (from == to) {
            return segmentTree[treeIdx] = seq[from];
        }

        int mid = (from + to) / 2;

        return segmentTree[treeIdx] = initSegmentTree(treeIdx * 2, from, mid) * initSegmentTree(treeIdx * 2 + 1, mid + 1, to) % 1000000007;
    }

    static long getPartitionMul(int treeIdx, int tFrom, int tTo, int from, int to) {
        if (tTo < from || to < tFrom) {
            return 1;
        }

        if (from <= tFrom && tTo <= to) {
            return segmentTree[treeIdx];
        }

        int mid = (tFrom + tTo) / 2;

        return getPartitionMul(treeIdx * 2, tFrom, mid, from, to) * getPartitionMul(treeIdx * 2 + 1, mid + 1, tTo, from, to) % 1000000007;
    }

    static long changeSegmentTree(int treeIdx, int from, int to, int targetIdx, int targetNum) {
        if (targetIdx < from || to < targetIdx) {
            return segmentTree[treeIdx];
        }

        if (from == to) {
            return segmentTree[treeIdx] = targetNum;
        }

        int mid = (from + to) / 2;
        return segmentTree[treeIdx] = changeSegmentTree(treeIdx * 2, from, mid, targetIdx, targetNum) * changeSegmentTree(treeIdx * 2 + 1, mid + 1, to, targetIdx, targetNum) % 1000000007;
    }
}
