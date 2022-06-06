import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, preIdx;
    static int[] in, post, pre;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        pre = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        setPre(0, n - 1, 0, n - 1);
        for (Integer i : pre) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }


    private static void setPre(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight) return;
        if (inLeft == inRight) {
            pre[preIdx++] = in[inLeft];
            return;
        }

        int root = post[postRight];

        pre[preIdx++] = root;


        int LSize = 0;
        int RSize = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (in[i] == root) {
                LSize = i - inLeft;
                RSize = inRight - i;
                break;
            }
        }

        setPre(inLeft, inLeft + LSize - 1, postLeft, postLeft + LSize - 1);
        setPre(inRight - RSize + 1, inRight, postRight - 1 - RSize + 1, postRight - 1);
    }
}
