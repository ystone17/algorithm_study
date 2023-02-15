import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] segmentTree, seq;
    static int n, k;

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s == null) break;

            st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            segmentTree = new int[getTreeSize(n)];
            seq = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                seq[i + 1] = Integer.compare(Integer.parseInt(st.nextToken()), 0);
            }

            initSegmentTree(1, n, 1);

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (command.equals("C")) {
                    seq[a] = Integer.compare(b, 0);
                    change(1, n, a, 1);
                    continue;
                }

                int mul = getMul(1, n, a, b, 1);
                if (mul != 0) {
                    sb.append(mul > 0 ? "+" : "-");
                    continue;
                }

                sb.append("0");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int getTreeSize(int n) {
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        return (int) Math.pow(2, h + 1) + 1;
    }

    private static int initSegmentTree(int left, int right, int treeIdx) {
        if (left == right) {
            return segmentTree[treeIdx] = seq[left];
        }

        int mid = (left + right) / 2;

        int l = initSegmentTree(left, mid, treeIdx * 2);
        int r = initSegmentTree(mid + 1, right, treeIdx * 2 + 1);

        return segmentTree[treeIdx] = l * r;
    }

    private static int getMul(int left, int right, int start, int end, int treeIdx) {
        if (end < left || right < start) {
            return 1;
        }

        if (start <= left && right <= end) {
            return segmentTree[treeIdx];
        }

        int mid = (left + right) / 2;

        int l = getMul(left, mid, start, end, treeIdx * 2);
        int r = getMul(mid + 1, right, start, end, treeIdx * 2 + 1);

        return l * r;
    }

    private static int change(int left, int right, int changeIdx, int treeIdx) {
        if (changeIdx < left || right < changeIdx) {
            return segmentTree[treeIdx];
        }

        if (left == right) {
            return segmentTree[treeIdx] = seq[changeIdx];
        }

        int mid = (left + right) / 2;

        int l = change(left, mid, changeIdx, treeIdx * 2);
        int r = change(mid + 1, right, changeIdx, treeIdx * 2 + 1);

        return segmentTree[treeIdx] = l * r;
    }
}
