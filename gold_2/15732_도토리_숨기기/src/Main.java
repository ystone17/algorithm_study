import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, d, minLeft = 1_000_000_000;
    static List<Rule> rules = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            var a = Integer.parseInt(st.nextToken());
            minLeft = Math.min(minLeft, a);

            rules.add(new Rule(
                    a,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int left = minLeft;
        int right = 1_000_000;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (total(mid) >= d) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int total(int boxNum) {
        int total = 0;
        for (Rule rule : rules) {
            total += rule.total(boxNum);
        }

        return total;
    }


    static class Rule {
        int a;
        int b;
        int c;

        public Rule(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int total(int boxNum) {
            if (boxNum < a || b < boxNum) {
                return 0;
            }

            return (boxNum - a) / c + 1;
        }
    }
}
