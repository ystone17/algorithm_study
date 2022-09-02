import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static String[] s;
    static String[] target;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        s = new String[n];
        target = new String[m];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            target[i] = br.readLine();
        }

        int res =0 ;

        for (String t : target) {
            for (String s1 : s) {
                if(t.equals(s1)){
                    res++;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
