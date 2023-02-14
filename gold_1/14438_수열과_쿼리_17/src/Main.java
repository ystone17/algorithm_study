import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, treeSize, queryN;
    static int[] seq;
    static int[] minTree;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i + 1] = Integer.parseInt(st.nextToken());
        }

        int x = (int) Math.ceil((Math.log(n) / Math.log(2)));
        int two = 1;
        for (int i = 0; i <= x; i++) {
            treeSize += two;
            two *= 2;
        }

        minTree = new int[treeSize + 1];
        initTree(1, n, 1);

        queryN = Integer.parseInt(br.readLine());
        for (int cnt = 0; cnt < queryN; cnt++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (q == 1) {
                seq[i] = v;
                add(1, n, i, 1);
            } else {
                sb.append(getMin(1, n, i, v, 1)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int initTree(int left, int right, int treeIdx) {
        if (left == right) {
            return minTree[treeIdx] = seq[left];
        }

        int mid = (left + right) / 2;

        int l = initTree(left, mid, treeIdx * 2);
        int r = initTree(mid + 1, right, treeIdx * 2 + 1);

        return minTree[treeIdx] = Math.min(l, r);
    }

    private static int getMin(int left, int right, int fL, int fR, int treeIdx) {
        if (right < fL || fR < left) {
            return Integer.MAX_VALUE;
        }

        if (fL <= left && right <= fR) {
            return minTree[treeIdx];
        }

        int mid = (left + right) / 2;

        return Math.min(getMin(left, mid, fL, fR, treeIdx * 2), getMin(mid + 1, right, fL, fR, treeIdx * 2 + 1));
    }

    private static int add(int left, int right, int addIdx, int treeIdx) {
        if (addIdx < left || right < addIdx) return minTree[treeIdx];

        if (left == right) {
            return minTree[treeIdx] = seq[addIdx];
        }

        int mid = (left + right) / 2;

        int l = add(left, mid, addIdx, treeIdx * 2);
        int r = add(mid + 1, right, addIdx, treeIdx * 2 + 1);

        return minTree[treeIdx] = Math.min(l, r);
    }
}
