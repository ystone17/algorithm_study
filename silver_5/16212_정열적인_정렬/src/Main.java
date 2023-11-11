import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}
