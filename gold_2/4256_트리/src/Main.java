import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int n;
    static int[] preOrder, inOrder;
    static String postOrder;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            postOrder = "";
            n = Integer.parseInt(br.readLine());
            preOrder = new int[n];
            inOrder = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
            }

            getPostOrder(0, n, 0, n);
            sb.append(postOrder).append("\n");
        }
        System.out.println(sb);
    }

    static void getPostOrder(int preStartInclusiveIdx, int preEndExclusiveIdx, int inStartInclusiveIdx, int inEndExclusiveIdx) {
        if (preStartInclusiveIdx - preEndExclusiveIdx == 0) {
            return;
        }

        if (preStartInclusiveIdx - preEndExclusiveIdx == 1) {
            postOrder = preOrder[preStartInclusiveIdx] + " " + postOrder;
            return;
        }

        int preOrderRoot = preOrder[preStartInclusiveIdx];
        int inOrderRootIdx = 0;
        for (int i = inStartInclusiveIdx; i < inEndExclusiveIdx; i++) {
            if (inOrder[i] == preOrderRoot) {
                inOrderRootIdx = i;
                break;
            }
        }

        postOrder = preOrderRoot + " " + postOrder;
        int leftSize = inOrderRootIdx - inStartInclusiveIdx;

        getPostOrder(
                preStartInclusiveIdx + 1 + leftSize, preEndExclusiveIdx,
                inOrderRootIdx + 1, inEndExclusiveIdx);
        getPostOrder(
                preStartInclusiveIdx + 1, preStartInclusiveIdx + 1 + leftSize,
                inStartInclusiveIdx, inOrderRootIdx);
    }


}
