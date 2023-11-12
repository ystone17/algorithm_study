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

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (char c : br.readLine().toCharArray()) {
                if (c - '0' < 0 || c - '0' > 9) {
                    if (sb.length() != 0) {
                        list.add(Long.parseLong(sb.toString()));
                        sb = new StringBuilder();
                    }
                    continue;
                }

                sb.append(c);
            }
            if (sb.length() != 0) {
                list.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }
        }

        Collections.sort(list);
        for (Long l : list) {
            sb.append(l).append("\n");
        }
        System.out.println(sb);
    }
}
