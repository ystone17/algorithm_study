import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static Map<Integer, String> title = new HashMap<>();
    static List<Integer> maxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            var t = st.nextToken();
            var max = Integer.parseInt(st.nextToken());

            if (title.containsKey(max)) {
                continue;
            }

            title.put(max, t);
            maxes.add(max);
        }

        Collections.sort(maxes);

        for (int i = 0; i < m; i++) {
            var attack = Integer.parseInt(br.readLine());
            sb.append(title.get(maxes.get(binarySearch(attack)))).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int target) {
        var left = 0;
        var right = maxes.size() - 1;
        var mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if(maxes.get(mid) == target) {
                return mid;
            }

            if(maxes.get(mid) < target) {
                left = mid + 1;
            }

            if(maxes.get(mid) > target) {
                right = mid;
            }
        }

        return left;
    }
}
