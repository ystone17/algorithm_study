import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, s;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            if (oper.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                s |= 1 << num;
            } else if (oper.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                s = s & ~(1 << num);
            } else if (oper.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                sb.append((s & (1 << num)) != 0 ? 1 : 0).append("\n");
            } else if (oper.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                s ^= 1 << num;
            } else if (oper.equals("all")) {
                s = (1 << 21) - 1;
            } else if (oper.equals("empty")) {
                s = 0;
            }
        }
        System.out.println(sb);
    }
}
