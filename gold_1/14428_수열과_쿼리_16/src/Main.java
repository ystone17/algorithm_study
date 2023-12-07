import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, q, a, b, c;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int[] seq = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i + 1] = Integer.parseInt(st.nextToken());
        }

        SegmentTree segmentTree = new SegmentTree(n, seq);

        q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                segmentTree.update(b, c);
            } else {
                sb.append(segmentTree.min(b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class SegmentTree {
        int n;
        List<Node> tree;
        int[] seq;

        public SegmentTree(int n, int[] seq) {
            this.n = n;
            this.tree = new ArrayList<>();
            for (int i = 0; i < size(n) + 1; i++) {
                tree.add(null);
            }
            this.seq = seq;

            init();
        }

        private int size(int n) {
            int height = (int) Math.ceil(Math.log(n) / Math.log(2) + 1);
            return (int) Math.pow(2, height);
        }

        private void init() {
            initDp(1, this.n, 1);
        }

        private void initDp(int left, int right, int idx) {
            if (left == right) {
                tree.set(idx, new Node(seq[left], left));
                return;
            }

            initDp(left, (left + right) / 2, idx * 2);
            initDp((left + right) / 2 + 1, right, idx * 2 + 1);

            Node lNode = tree.get(idx * 2);
            Node rNode = tree.get(idx * 2 + 1);

            if (lNode.compareTo(rNode) > 0) {
                tree.set(idx, new Node(rNode.value, rNode.idx));
            } else {
                tree.set(idx, new Node(lNode.value, lNode.idx));
            }
        }

        private int min(int i, int j) {
            return minDp(1, n, 1, i, j).idx;
        }

        private Node minDp(int left, int right, int idx, int i, int j) {
            if (j < left || right < i) {
                return new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }

            if (i <= left && right <= j) {
                return tree.get(idx);
            }

            Node lNode = minDp(left, (left + right) / 2, idx * 2, i, j);
            Node rNode = minDp((left + right) / 2 + 1, right, idx * 2 + 1, i, j);

            if (lNode.compareTo(rNode) > 0) {
                return rNode;
            } else {
                return lNode;
            }
        }

        private void update(int i, int k) {
            seq[i] = k;
            updateDp(1, n, 1, i, k);
        }

        private Node updateDp(int left, int right, int idx, int i, int k) {
            if (i < left || right < i) {
                return tree.get(idx);
            }

            if (left == right) {
                Node nNode = new Node(k, i);
                tree.set(idx, nNode);
                return nNode;
            }

            Node lNode = updateDp(left, (left + right) / 2, idx * 2, i, k);
            Node rNode = updateDp((left + right) / 2 + 1, right, idx * 2 + 1, i, k);

            if (lNode.compareTo(rNode) > 0) {
                tree.set(idx, rNode);
                return rNode;
            } else {
                tree.set(idx, lNode);
                return lNode;
            }

        }
    }

    static class Node implements Comparable<Node> {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (value != o.value) {
                return Integer.compare(value, o.value);
            }

            return Integer.compare(idx, o.idx);
        }
    }
}
