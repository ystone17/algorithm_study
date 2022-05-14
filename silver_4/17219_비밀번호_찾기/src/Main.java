import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] num = new int[2];
    static Map<String, String> pwd = new HashMap<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pwd.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            bw.write(pwd.get(br.readLine()));
            bw.newLine();
        }

        bw.flush();



    }
}
