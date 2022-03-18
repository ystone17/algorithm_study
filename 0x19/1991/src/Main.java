import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] lc, rc;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        lc = new int[N + 1];
        rc = new int[N + 1];

        for (int i = 0; i < N; i++) {
            char[] alpha = br.readLine().toCharArray();

            lc[alpha[0] - 64] = alpha[2] - 64;
            rc[alpha[0] - 64] = alpha[4] - 64;
        }

        preOrder(1);
        bw.newLine();
        inOrder(1);
        bw.newLine();
        postOrder(1);
        bw.flush();
        bw.close();
        br.close();

    }

    static void preOrder(int root) throws IOException {
        bw.write(root+64);
        if(lc[root] != -18) preOrder(lc[root]);
        if(rc[root] != -18) preOrder(rc[root]);
    }

    static void inOrder(int root) throws IOException {
        if(lc[root] != -18) inOrder(lc[root]);
        bw.write(root+64);
        if(rc[root] != -18) inOrder(rc[root]);
    }

    static void postOrder(int root) throws IOException {
        if(lc[root] != -18) postOrder(lc[root]);
        if(rc[root] != -18) postOrder(rc[root]);
        bw.write(root+64);
    }


}
