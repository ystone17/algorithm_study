import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] seq;
    static int[] segmentTree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        segmentTree = new int[(int) (Math.pow(2, h + 1))];
        init(1, 0, n - 1);


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            sb.append(get(1, 0, n - 1, a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static int init(int treeIdx, int left, int right) {
        if (left == right) {
            return segmentTree[treeIdx] = seq[left];
        }

        int mid = (left + right) / 2;

        int l = init(treeIdx * 2, left, mid);
        int r = init(treeIdx * 2 + 1, mid + 1, right);

        return segmentTree[treeIdx] = Math.min(l, r);
    }

    static int get(int treeIdx, int left, int right, int hopeL, int hopeR) {
        if (hopeR < left || right < hopeL) {
            return Integer.MAX_VALUE;
        }

        if (hopeL <= left && right <= hopeR) {
            return segmentTree[treeIdx];
        }

        int mid = (left + right) / 2;

        int l = get(treeIdx * 2, left, mid, hopeL, hopeR);
        int r = get(treeIdx * 2 + 1, mid + 1, right, hopeL, hopeR);

        return Math.min(l, r);
    }


}
