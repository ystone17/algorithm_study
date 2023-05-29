import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int s, e, res;
    static int[] seq = new int[1000];

    public static void main(String[] args) throws IOException {
        initSeq();
        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = s-1; i < e; i++) {
            res += seq[i];
        }

        System.out.println(res);
    }

    private static void initSeq() {
        int idx = 0;

        for (int i = 1; i < 100; i++) {
            for (int j = 0; j < i; j++) {
                if(idx == 1000) return;

                seq[idx++] = i;
            }
        }
    }
}
