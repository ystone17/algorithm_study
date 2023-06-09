import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<Integer> set;
    static int n, total;

    public static void main(String[] args) throws IOException {
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            set = new HashSet<>();
            set.add(1);
            total = 0;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    set.add(i);
                    set.add(n / i);
                }
            }

            for (Integer i : set) {
                total += i;
            }

            if (total != n) {
                sb.append(String.format("%d is NOT perfect.", n)).append("\n");
                continue;
            }

            sb.append(n).append(" = ");

            List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                sb.append(collect.get(i));
                if (i == collect.size() - 1) break;
                sb.append(" + ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
