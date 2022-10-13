import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Map<String, String> map = new HashMap<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (b.equals("enter")) {
                map.putIfAbsent(a, b);
            } else {
                map.remove(a);
            }
        }

        String[] keyArr = map.keySet().toArray(new String[0]);
        Arrays.sort(keyArr, Collections.reverseOrder());

        for (String s : keyArr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }
}
