import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, q;
    static long[] seq;
    static int x, y, a, b;

    static long[] segmentTree;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        seq = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Long.parseLong(st.nextToken());
        }

        initSegmentTree();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            long partitionSum = getPartitionSum(0, seq.length - 1, 1, x - 1, y - 1);
            update(0, seq.length - 1, 1, a - 1, b - seq[a - 1]);
            seq[a - 1] = b;
            sb.append(partitionSum).append("\n");
        }

        System.out.println(sb);
    }

    static void initSegmentTree() {
        int h = (int) Math.ceil(Math.log(seq.length) / Math.log(2));
        int size = (int) Math.pow(2, h + 1);

        segmentTree = new long[size];

        init(0, seq.length - 1, 1);
    }

    static long init(int start, int end, int node) {
        if (start == end) {
            return segmentTree[node] = seq[start];
        }

        int mid = (start + end) / 2;

        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static long getPartitionSum(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;

        return getPartitionSum(start, mid, node * 2, left, right) + getPartitionSum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || end < idx) {
            return;
        }

        segmentTree[node] += diff;

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }
}
